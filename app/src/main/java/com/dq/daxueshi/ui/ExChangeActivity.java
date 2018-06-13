package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的-积分-积分商城-提交订单（兑换）
 * Created by jingang on 2018/6/9.
 */

public class ExChangeActivity extends BaseActivity {
    @Bind(R.id.linExChangeAdr)
    LinearLayout linExChangeAdr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_exchange);
        ButterKnife.bind(this);
        setTvTitle("提价订单");
        setIvBack();
    }

    @OnClick(R.id.linExChangeAdr)
    public void onViewClicked() {
        goToActivity(AdrListActivity.class);
    }
}
