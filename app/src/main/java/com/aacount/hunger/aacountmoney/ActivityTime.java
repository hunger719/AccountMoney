package com.aacount.hunger.aacountmoney;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.aacount.hunger.aacountmoney.entitybean.CHeckBoxState;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;
import static com.aacount.hunger.aacountmoney.R.id.btn;
import static com.aacount.hunger.aacountmoney.R.id.btnch;
import static com.aacount.hunger.aacountmoney.R.id.btncl;
import static com.aacount.hunger.aacountmoney.R.id.btnpp;

public class ActivityTime extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShow = null;
    private TextView tvTotal = null;
    private Button btnOK = null;

    private EditText editNo = null;
    private CheckBox checkXA = null;
    private CheckBox checkYH = null;
    private CheckBox checkCL = null;
    private CheckBox checkCH = null;
    private CheckBox checkPP = null;

    private Button btnXA = null;
    private Button btnYH = null;
    private Button btnCL = null;
    private Button btnCH = null;
    private Button btnPP = null;

    private List<CHeckBoxState> checkBoxStates; //复选框选中状态集合
    private List<Double> everyXFdoubleList = null;
    private List<String> everyXFstringList = null;
    private String everyXFString = ""; //平均每个人消费
    private double everyXFDouble = 0;

    private double xaZC = 0; //支出
    private double yhZC = 0;
    private double clZC = 0;
    private double chZC = 0;
    private double ppZC = 0;

    private String xaXF = ""; //消费
    private String yhXF = "";
    private String clXF = "";
    private String chXF = "";
    private String ppXF = "";

    private SharedPreferences sp = null;
    private String strShow = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_by_time);

        tvShow = ((TextView) findViewById(R.id.tvshow));
        tvTotal = ((TextView) findViewById(R.id.tvtotal));
        btnOK = ((Button) findViewById(R.id.ok));
        editNo = ((EditText) findViewById(R.id.editno));
        checkXA = ((CheckBox) findViewById(R.id.checkXA));
        checkYH = ((CheckBox) findViewById(R.id.checkYH));
        checkCL = ((CheckBox) findViewById(R.id.checkCL));
        checkCH = ((CheckBox) findViewById(R.id.checkCH));
        checkPP = ((CheckBox) findViewById(R.id.checkPP));
        editNo = ((EditText) findViewById(R.id.editno));
        btnXA = ((Button) findViewById(R.id.btnXA));
        btnYH = ((Button) findViewById(R.id.btnYH));
        btnCL = ((Button) findViewById(R.id.btnCL));
        btnCH = ((Button) findViewById(R.id.btnCH));
        btnPP = ((Button) findViewById(R.id.btnPP));

        sp = this.getSharedPreferences("personspendtotal", 0);
        everyXFstringList = new ArrayList<>();
        everyXFdoubleList = new ArrayList<>();
        checkBoxStates = new ArrayList<>();
        strShow = name + " : ";
        regEvent(true);
    }

    private void regEvent(boolean b) {
        if (null != btnOK) {
            btnOK.setOnClickListener(b ? this : null);
        }
        if (null != btnXA) {
            btnXA.setOnClickListener(b ? this : null);
        }
        if (null != btnYH) {
            btnYH.setOnClickListener(b ? this : null);
        }
        if (null != btnCL) {
            btnCL.setOnClickListener(b ? this : null);
        }
        if (null != btnCH) {
            btnCH.setOnClickListener(b ? this : null);
        }
        if (null != btnPP) {
            btnPP.setOnClickListener(b ? this : null);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
