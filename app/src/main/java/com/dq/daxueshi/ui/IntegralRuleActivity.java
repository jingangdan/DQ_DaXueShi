package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;

/**
 * 我的-积分-积分规则
 * Created by jingang on 2018/6/8.
 */

public class IntegralRuleActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_integral_rule);
        setTvTitle("积分规则");
        setIvBack();
    }
}
