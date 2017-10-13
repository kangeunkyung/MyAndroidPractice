package com.example.eunkong.myandroidpractice;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by eunkong on 2017. 10. 12..
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    final static String TAG = MyFirebaseInstanceIdService.class.getSimpleName();

    public MyFirebaseInstanceIdService() {
        Log.d(TAG, "MyFirebaseInstanceIdService()");
    }

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token : " + refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        // TODO Implement this method to send token to your app server.

    }
}
