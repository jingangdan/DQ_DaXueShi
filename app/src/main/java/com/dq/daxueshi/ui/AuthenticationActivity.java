package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 大学生认证
 * Created by jingang on 2018/6/7.
 */

public class AuthenticationActivity extends BaseActivity {
    @Bind(R.id.butAut)
    Button butAut;
    @Bind(R.id.tvAut)
    TextView tvAut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_authentication);
        ButterKnife.bind(this);
        setTvTitle("大学生认证");
        setIvBack();
    }

    @OnClick({R.id.butAut, R.id.tvAut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.butAut:
                goToActivity(MainActivity.class);
                break;
            case R.id.tvAut:
                goToActivity(MainActivity.class);
                break;
        }
    }
}
