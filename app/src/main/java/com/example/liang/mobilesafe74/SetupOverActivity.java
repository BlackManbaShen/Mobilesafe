package com.example.liang.mobilesafe74;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.liang.mobilesafe74.utils.ConstantValue;
import com.example.liang.mobilesafe74.utils.SpUtil;

public class SetupOverActivity extends AppCompatActivity {

    private TextView tv_phone;
    private TextView tv_reset_setup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean setup_over = SpUtil.getBoolean(this, ConstantValue.setup_over, false);
        if (setup_over){
            //密码输入成功，并且四个导航界面设置完成---->停留在设置完成功能列表界面
            setContentView(R.layout.activity_setup_over);
            initUI();
        }else {
            //密码输入成功，四个导航界面没有设置完成---->跳转到导航界面第一个
            Intent intent = new Intent(this, Setup1Activity.class);
            startActivity(intent);
            //开启新的界面后，关闭功能列表界面
            finish();
        }
    }

    private void initUI() {
        tv_phone = (TextView)findViewById(R.id.tv_phone);
        //设置联系人号码
        String phone = SpUtil.getString(this, ConstantValue.contact_phone, "");
        tv_phone.setText(phone);
        //重新设置条目被点击
        tv_reset_setup = (TextView)findViewById(R.id.tv_reset_setup);
        tv_reset_setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Setup1Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
