package com.cyo.ex4_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Created by USER on 2015/4/3.
 */
public class BMI_Result extends Activity {
    private Button btn_back;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_result);
        findViews();
        showinfo();
    }

    protected void findViews() {

        btn_back = (Button) findViewById(R.id.btn_back);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              返回
                BMI_Result.this.finish();
            }
        });
    }

    private void showinfo() {
//      新建bundle取得intent內容
        Bundle bundle = this.getIntent().getExtras();
//        取得傳過來的Double物件，key為"hight"、weight
        Double hight = bundle.getDouble("hight");
        Double weight = bundle.getDouble("weight");
//        將Double物件轉成##.##的String物件
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
//        計算BMI
        Double BMI = weight / (hight * hight);

        if (BMI < 18.5) {
            tv_result.setText("BMI值為:" + decimalFormat.format(BMI) + "\n" + "過瘦");
        } else if (BMI >= 24) {
            tv_result.setText("BMI值為:" + decimalFormat.format(BMI) + "\n" + "過重");
        } else {
            tv_result.setText("BMI值為:" + decimalFormat.format(BMI) + "\n" + "正常");
        }


    }

}