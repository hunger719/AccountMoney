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
import android.widget.Toast;

import com.aacount.hunger.aacountmoney.entitybean.CHeckBoxState;
import com.aacount.hunger.aacountmoney.util.Util;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.x;

public class ActivityCoutByPerson extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName = null;
    private TextView tvShow = null;
    private TextView tvTotal = null;
    private String name;
    private Intent intent;
    private Button btnNext = null;
    private Button btnlast = null;
    private Button btnOK = null;
    private EditText editNo = null;
    private CheckBox checkXA = null;
    private CheckBox checkYH = null;
    private CheckBox checkCL = null;
    private CheckBox checkCH = null;
    private CheckBox checkPP = null;

    private List<CHeckBoxState> checkBoxStates;

    private List<String> strEveryNOs = null;
    private List<Double> doubleEveryNOs = null;

    private SharedPreferences sp = null;

    private double doubleeveryNo = 0;
    private String texteveryNo;
    private String strShow;
    private double sum = 0;
    private double every = 0;

    private double xa = 0;
    private double yh = 0;
    private double cl = 0;
    private double ch = 0;
    private double pp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cout_by_person);
        intent = this.getIntent();
        name = intent.getStringExtra("personname");
        tvName = ((TextView) findViewById(R.id.tvname));
        tvShow = ((TextView) findViewById(R.id.tvshow));
        tvTotal = ((TextView) findViewById(R.id.tvtotal));
        btnOK = ((Button) findViewById(R.id.ok));
        btnNext = ((Button) findViewById(R.id.nexttip));
        btnlast = ((Button) findViewById(R.id.lasttip));
        editNo = ((EditText) findViewById(R.id.editno));
        checkXA = ((CheckBox) findViewById(R.id.checkXA));
        checkYH = ((CheckBox) findViewById(R.id.checkYH));
        checkCL = ((CheckBox) findViewById(R.id.checkCL));
        checkCH = ((CheckBox) findViewById(R.id.checkCH));
        checkPP = ((CheckBox) findViewById(R.id.checkPP));
        sp = this.getSharedPreferences("personspendtotal", 0);
        tvName.setText(name);
        editNo.setFocusable(true);
        editNo.setFocusableInTouchMode(true);
        editNo.requestFocus();
        strEveryNOs = new ArrayList<>();
        doubleEveryNOs = new ArrayList<>();
        checkBoxStates = new ArrayList<>();
        strShow = name + " : ";
        regEvent(true);
    }

    private void regEvent(boolean b) {
        if (null != btnOK) {
            btnOK.setOnClickListener(b ? this : null);
        }
        if (null != btnNext) {
            btnNext.setOnClickListener(b ? this : null);
        }
        if (null != btnlast) {
            btnlast.setOnClickListener(b ? this : null);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnOK) {

            SharedPreferences.Editor editor = sp.edit();
            editor.putString(name + "支出", "" + sum);
            editor.commit();
            putDataToSP();
            setCheckBoxUcheck();
            Util.showToast(this, "潇昂" + sp.getString("xa消费", ""));


        } else if (v == btnNext) {
            showAdd();
            updatePersoncost(1);

            setCheckBoxUcheck();

        } else if (v == btnlast) {
            showSub();
            updatePersoncost(2);
            setCheckBoxUcheck();
        }
    }

    //点击下一条时候下面的显示
    private void showAdd() {
        tvShow.setText("");
        tvTotal.setText("");
        texteveryNo = editNo.getText().toString();
        if (!"".equals(texteveryNo)) {
            strEveryNOs.add(texteveryNo);
            doubleeveryNo = Double.parseDouble(texteveryNo);
            doubleEveryNOs.add(doubleeveryNo);
            every = Util.div(doubleeveryNo, getCheckedNum());
            sum = Util.add(sum, doubleeveryNo);
            strShow += texteveryNo + " + ";
        }
        tvShow.setText(strShow);
        tvTotal.setText("总共 ： " + sum);
        editNo.setText("");
    }

    //点击返回一条时候下面的显示
    private void showSub() {
        tvShow.setText("");
        tvTotal.setText("");
        if (strEveryNOs.size() > 0) {
            String s = strEveryNOs.get(strEveryNOs.size() - 1);
            doubleeveryNo = Double.parseDouble(s);
            strEveryNOs.remove(strEveryNOs.size() - 1);
            doubleEveryNOs.add(doubleeveryNo);
            every = Util.div(doubleeveryNo, getCheckedNum());
            sum = Util.sub(sum, doubleeveryNo);
            strShow = Util.subString(strShow, s.length() + 4);
        }
        tvShow.setText(strShow);
        tvTotal.setText("总共 ： " + sum);
    }

    /**
     * 修改个人消费累计
     *
     * @param i 1，加  2， 减
     */
    private void updatePersoncost(int i) {
        if (i == 1) {
            xa = Util.add(xa, every);
            yh = Util.add(yh, every);
            cl = Util.add(cl, every);
            ch = Util.add(ch, every);
            pp = Util.add(pp, every);
            if (checkXA.isChecked()) xa = Util.sub(xa, every);
            if (checkYH.isChecked()) yh = Util.sub(yh, every);
            if (checkCL.isChecked()) cl = Util.sub(cl, every);
            if (checkCH.isChecked()) ch = Util.sub(ch, every);
            if (checkPP.isChecked()) pp = Util.sub(pp, every);
        } else {
            xa = Util.sub(xa, every);
            yh = Util.sub(yh, every);
            cl = Util.sub(cl, every);
            ch = Util.sub(ch, every);
            pp = Util.sub(pp, every);
        }
    }

    /**
     * 将数据存储起来
     */
    private void putDataToSP() {
        SharedPreferences.Editor editor = sp.edit();

        String s = sp.getString("xa消费","0");
        double d = Double.parseDouble(s);
        double dd = Util.add(d, xa);
        editor.putString("xa消费", "" + dd);
        editor.commit();

        s = sp.getString("yh消费","0");
        d = Double.parseDouble(s);
        dd = Util.add(d, yh);
        editor.putString("yh消费", "" + dd);
        editor.commit();

        s = sp.getString("cl消费","0");
        d = Double.parseDouble(s);
        dd = Util.add(d, cl);
        editor.putString("cl消费", "" + dd);
        editor.commit();

        s = sp.getString("ch消费","0");
        d = Double.parseDouble(s);
        dd = Util.add(d, ch);
        editor.putString("ch消费", "" + dd);
        editor.commit();

        s = sp.getString("pp消费","0");
        d = Double.parseDouble(s);
        dd = Util.add(d, pp);
        editor.putString("pp消费", "" + dd);
        editor.commit();

    }

    private void setCheckBoxUcheck() {
        if (null != checkXA) checkXA.setChecked(false);
        if (null != checkYH) checkYH.setChecked(false);
        if (null != checkCL) checkCL.setChecked(false);
        if (null != checkCH) checkCH.setChecked(false);
        if (null != checkPP) checkPP.setChecked(false);
    }

    private double getCheckedNum() {
        CHeckBoxState state = new CHeckBoxState();
        int i = 5;
        if (null != checkXA) {
            if (checkXA.isChecked()) {
                i--;
                state.setCheckxa(true);
            }
        }
        if (null != checkYH) {
            if (checkYH.isChecked()) {
                i--;
                state.setCheckyh(true);
            }
        }
        if (null != checkCL) {
            if (checkCL.isChecked()) {
                i--;
                state.setCheckcl(true);
            }
        }
        if (null != checkCH) {
            if (checkCH.isChecked()) {
                i--;
                state.setCheckch(true);
            }
        }
        if (null != checkPP) {
            if (checkPP.isChecked()) {
                i--;
                state.setCheckpp(true);
            }
        }
        if (i <= 0) i = 1;
        checkBoxStates.add(state);
        return (double) i;
    }
}
