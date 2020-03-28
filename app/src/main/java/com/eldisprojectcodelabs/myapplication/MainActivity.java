package com.eldisprojectcodelabs.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private static final String STATE = "currentState";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        if (savedInstanceState != null){
            textView.setText(savedInstanceState.getString(STATE));
        }

    }

    public void startTask(View view){
        textView.setText("Napping...");

        //create object from background thread class
        AsynctaskSubclass asynctaskSubclass = new AsynctaskSubclass(textView);
        asynctaskSubclass.execute();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE, textView.getText().toString());
    }
}
