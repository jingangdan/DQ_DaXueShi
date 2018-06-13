package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;

/**
 * 收货地址-编辑地址（添加、修改）
 * Created by jingang on 2018/6/9.
 */

public class AdrUpdateActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_adr_update);
        setTvTitle("编辑地址");
        setIvBack();
    }
}
