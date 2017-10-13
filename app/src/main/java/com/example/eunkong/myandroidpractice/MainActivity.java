package com.example.eunkong.myandroidpractice;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        setFragment(MenuOneFragment.newInstance());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = getString(R.string.default_notification_channel_id);
            String channelName = getString(R.string.default_notification_channel_name);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_LOW));
        }

        // notification 메세지를 눌러서 들어왔을 때 데이터 처리하도록
        if(getIntent().getExtras() != null) {
            for(String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "key : " + key + ", value : " + value);

            }
        }

        FirebaseMessaging.getInstance().subscribeToTopic("News");
        FirebaseInstanceId.getInstance().getToken();

    }

    public void initView() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment currentFragment = null;

                switch(item.getItemId()) {
                    case R.id.menu_one:
                        Toast.makeText(MainActivity.this, "menu one", Toast.LENGTH_SHORT).show();
                        currentFragment = MenuOneFragment.newInstance();
                        break;

                    case R.id.menu_two:
                        Toast.makeText(MainActivity.this, "menu two", Toast.LENGTH_SHORT).show();
                        currentFragment = MenuTwoFragment.newInstance();
                        break;

                    case R.id.menu_three:
                        Toast.makeText(MainActivity.this, "menu three", Toast.LENGTH_SHORT).show();
                        currentFragment = MenuThreeFragment.newInstance();
                        break;
                }

                setFragment(currentFragment);


                return true;
            }

        });
    }


    public void setFragment(Fragment fragment){

        // todo fragment 인터페이스 만들어서 해보기

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commitAllowingStateLoss();

    }
}
