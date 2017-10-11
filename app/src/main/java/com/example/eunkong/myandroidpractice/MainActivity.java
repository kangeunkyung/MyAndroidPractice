package com.example.eunkong.myandroidpractice;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, currentFragment);
                transaction.commit();

                return true;
            }
        });


    }
}
