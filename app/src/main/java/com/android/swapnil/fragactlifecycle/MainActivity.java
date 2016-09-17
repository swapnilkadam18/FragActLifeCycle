package com.android.swapnil.fragactlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = MainActivity.class.getSimpleName();
    private Button nextAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextAct = (Button) findViewById(R.id.act_btn);
        String defaultText = nextAct.getText().toString()+ "B";
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

    private void sendMessageToUtil(String msg){
        Util.printOnConsole(TAG,msg);
    }

    @Override
    public void onClick(View view) {
        if(view == nextAct){
            sendMessageToUtil("onClick");
            Intent intent = new Intent(this,Activity_B.class);
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            sendMessageToUtil("onActivityResult");
        }
    }
}
