package com.dq.daxueshi.adapter;

import android.content.Context;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseAdapter;
import com.dq.daxueshi.base.ViewHolder;
import com.dq.daxueshi.bean.TestBean;

/**
 * 机关-学习交流（适配器）
 * Created by jingang on 2018/6/6.
 */

public class ForumAdapter extends BaseAdapter<TestBean.DateBean> {

    public ForumAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_forum;
    }

    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {

    }
}
