package com.guilherme.usjtapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Guilherme brito dos santos - ra 81617569
 */

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.guilherme.usjtapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("cicloDeVida", "MainActivity:onCreate");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("cicloDeVida", "MainActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("cicloDeVida", "MainActivity:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("cicloDeVida", "MainActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("cicloDeVida", "MainActivity:onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("cicloDeVida", "MainActivity:onRestart");
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
