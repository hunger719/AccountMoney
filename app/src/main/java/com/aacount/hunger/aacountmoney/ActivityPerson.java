package com.aacount.hunger.aacountmoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.aacount.hunger.aacountmoney.R.id.btn;

public class ActivityPerson extends AppCompatActivity implements View.OnClickListener{

    private Button btnBK;
    private Button btnXA;
    private Button btnYH;
    private Button btnCL;
    private Button btnCH;
    private Button btnPP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        btnBK = ((Button) findViewById(btn));
        btnXA = ((Button) findViewById(R.id.btnxa));
        btnYH = ((Button) findViewById(R.id.btnyh));
        btnCL = ((Button) findViewById(R.id.btncl));
        btnCH = ((Button) findViewById(R.id.btnch));
        btnPP = ((Button) findViewById(R.id.btnpp));

        regEvent(true);
    }

    private void regEvent(boolean b) {
        if (null != btnBK){
            btnBK.setOnClickListener(b ? this : null);
        }
        if (null != btnXA){
            btnXA.setOnClickListener(b ? this : null);
        }
        if (null != btnYH){
            btnYH.setOnClickListener(b ? this : null);
        }
        if (null != btnCL){
            btnCL.setOnClickListener(b ? this : null);
        }
        if (null != btnCH){
            btnCH.setOnClickListener(b ? this : null);
        }
        if (null != btnPP){
            btnPP.setOnClickListener(b ? this : null);
        }
    }

    @Override
    public void onClick(View v) {
        String name = "";
        Intent intent;
        if (v == btnBK){
            this.finish();
        }else
        {
            if (v == btnXA){
                name = "潇昂";
            }
            if (v == btnYH){
                name = "燕红";
            }
            if (v == btnCL){
                name = "成林";
            }
            if (v == btnCH){
                name = "陈汉";
            }
            if (v == btnPP){
                name = "飘飘";
            }

            intent = new Intent(ActivityPerson.this, ActivityCoutByPerson.class);
            intent.putExtra("personname",name);
            startActivity(intent);
        }
    }
}
