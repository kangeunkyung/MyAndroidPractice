package com.example.eunkong.myandroidpractice;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

import jobdispatcher.FirebaseJobDispatcher;
import jobdispatcher.GooglePlayDriver;
import jobdispatcher.Job;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by eunkong on 2017. 10. 12..
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    final static String TAG = MyFirebaseMessagingService.class.getSimpleName();

    public MyFirebaseMessagingService() {
        Log.d(TAG, "MyFirebaseMessagingService()");
    }

    /**
     * 앱이 foreground인 경우 알림과 데이터 메시지가 여기서 처리됨
     * 앱이 background인 경우 데이터 메시지(키-값 쌍으로 이루어져 있음) 가 여기서 처리됨
     * 데이터 메시지는 인텐트 부가정보로 전송됨
     * @param remoteMessage
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From : " + remoteMessage.getFrom());

        // 메세지에 데이터 페이로드가 포함되는지 확인
        if(remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload : " + remoteMessage.getData());
            Log.d(TAG, "message data payload : " + remoteMessage.getNotification().getTitle() + ", body : " + remoteMessage.getNotification().getBody() +  ", clickaction : " + remoteMessage.getNotification().getClickAction());

            // 데이터 처리가 10초 이상인경우
            if(false) {
                scheduleJob();
            } else {
                handleNow();
            }
        }

        // 메세지에 알림 페이로드가 포함되는지 확인
        if(remoteMessage.getNotification() != null) {

            Log.d(TAG, "message Notification title : " + remoteMessage.getNotification().getTitle() + ", body : " + remoteMessage.getNotification().getBody() +  ", clickaction : " + remoteMessage.getNotification().getClickAction());
        }

        sendNotification(remoteMessage);
    }

    private void scheduleJob() {
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
        Job myJob = dispatcher.newJobBuilder()
                .setService(MyJobService.class)
                .setTag("my-job-tag")
                .build();

        dispatcher.schedule(myJob);

    }

    private void handleNow() {

        Log.d(TAG, "Short lived stask is one.");
    }

    private void sendNotification(RemoteMessage remoteMessage) {
        String title = remoteMessage.getData().get("title");
        String message = remoteMessage.getData().get("body");
        Log.d(TAG, "sendNotification() - title : " + title + ", message : " + message);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        // 앱이 foreground로 들어온 게 아닌 경우 notification의 제목과 내용 설정
        // 다음은 firebase console로 보낼 경우를 기준으로 처리함
        if(TextUtils.isEmpty(title)) {
            title = getString(R.string.app_name);

        }
        if(TextUtils.isEmpty(message)) {
            message = remoteMessage.getNotification().getBody();
        }

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // 앱이 foreground인 경우 알림 메세지 처리하는 부분
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(0xff0000)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notificationBuilder.build());


    }

}
