package com.example.eunkong.myandroidpractice;

import android.util.Log;

import jobdispatcher.JobParameters;
import jobdispatcher.JobService;

/**
 * Created by eunkong on 2017. 10. 12..
 */

public class MyJobService extends JobService {
    private static final String TAG = MyJobService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters job) {
        Log.d(TAG, "Performing long running task in scheduled job");
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters job) {

        return false;
    }
}
