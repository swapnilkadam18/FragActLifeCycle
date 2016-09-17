package com.android.swapnil.fragactlifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity_B extends AppCompatActivity implements View.OnClickListener  {

    private final static String TAG = Activity_B.class.getSimpleName();
    private Button nextAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        sendMessageToUtil("onCreate");

        nextAct = (Button) findViewById(R.id.act_btn);
        String defaultText = nextAct.getText().toString() + "A";
        nextAct.setText(defaultText);
        nextAct.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sendMessageToUtil("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        sendMessageToUtil("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        sendMessageToUtil("onRestart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        sendMessageToUtil("onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        sendMessageToUtil("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        sendMessageToUtil("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sendMessageToUtil("onDestroy");
    }

    @Override
    public void onClick(View view) {
        if(view == nextAct){
            sendMessageToUtil("onClick");
            Intent resultIntent = new Intent();
            setResult(Activity.RESULT_OK,resultIntent);
            finish();
        }
    }

    private static void sendMessageToUtil(String msg){
        Util.printOnConsole(TAG,msg);
    }
}
