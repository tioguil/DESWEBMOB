package com.guilherme.usjtapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("cicloDeVida", "SegundaActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("cicloDeVida", "SegundaActivity:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("cicloDeVida", "SegundaActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("cicloDeVida", "SegundaActivity:onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("cicloDeVida", "SegundaActivity:onRestart");
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("cicloDeVida", "SegundaActivity:onCreate");
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message =
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);
    }
}
