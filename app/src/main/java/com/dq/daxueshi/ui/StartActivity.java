package com.dq.daxueshi.ui;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;

/**
 * 启动页
 * Created by jingang on 2016/10/17.
 */
public class StartActivity extends BaseActivity {
    private SharedPreferences sharedPreferences;
    private String user;//判断用户是否为首次进入

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_start);

        sharedPreferences = getSharedPreferences("config", 0);
        user = sharedPreferences.getString("first", "1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goToActivity(StartPageActivity.class);
//                if (user.equals("1")) {
//                    //首次进入
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("first", "0");
//                    editor.commit();
//                    goToActivity(StartPageActivity.class);
//                } else {
//                    goToActivity(AuthenticationActivity.class);
//                }
                finish();
            }
        }).start();
    }
}