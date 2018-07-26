package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.utils.ScreenManagerUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页-发布（图文、视频）
 * Created by jingang on 2018/6/5.
 */

public class PublishActivity extends BaseActivity {
    @Bind(R.id.iv_publish_back)
    ImageView ivPublishBack;
    @Bind(R.id.butPublishText)
    Button butPublishText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_publish);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.butPublishText, R.id.iv_publish_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.butPublishText:
               // goToActivity(PublishPostActivity.class);
                goToActivity(PublishPostActivity.class);
                finish();
                break;
            case R.id.iv_publish_back:
                ScreenManagerUtils.getInstance().removeActivity(PublishActivity.this);
                overridePendingTransition(0, R.anim.anim_out);
                break;
        }
    }
}
