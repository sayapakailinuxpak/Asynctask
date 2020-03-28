package com.eldisprojectcodelabs.myapplication;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class AsynctaskSubclass extends AsyncTask<Void, Void, String> {
    private static final String TAG = "AsynctaskSubclass";
    private WeakReference<TextView> weakReferenceTextView; //to prevent memory leaks

    AsynctaskSubclass(TextView textView){
        weakReferenceTextView = new WeakReference<>(textView);
    }

    //this method run on background Thread
    @Override
    protected String doInBackground(Void... voids) {
        Log.d(TAG, "status: doInBackground()");

        Random randomNumber = new Random();
        int n = randomNumber.nextInt(11);
        int s = n * 200;

        try {
            Thread.sleep(s);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + s + " milliseconds";
    }


    //this method run on UI Thread
    @Override
    protected void onPostExecute(String result) {
        weakReferenceTextView.get().setText(result);
    }
}
