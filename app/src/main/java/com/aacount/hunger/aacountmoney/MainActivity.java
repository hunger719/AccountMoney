package com.aacount.hunger.aacountmoney;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1 = null;
    private Button btn2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = ((Button) findViewById(R.id.btn1));
        btn2 = ((Button) findViewById(R.id.btn2));

        regEvent(true);
    }

    private void regEvent(boolean b) {
        if (null != btn1){
            btn1.setOnClickListener(b ? this : null);
        }
        if (null != btn2){
            btn2.setOnClickListener(b ? this : null);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if (v == btn1){
            intent = new Intent(MainActivity.this,ActivityPerson.class);
        }
        if (v == btn2){
            intent = new Intent(MainActivity.this,ActivityTime.class);
        }

        this.startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();

        SharedPreferences sp = this.getSharedPreferences("personspendtotal", 0);
    }
}
