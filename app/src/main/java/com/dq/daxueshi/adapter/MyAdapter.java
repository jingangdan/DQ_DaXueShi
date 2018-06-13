package com.dq.daxueshi.adapter;

import android.content.Context;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseAdapter;
import com.dq.daxueshi.base.ViewHolder;
import com.dq.daxueshi.bean.TestBean;

/**
 * 列表适配器
 * Created by jingang on 2018/6/8.
 */

public class MyAdapter extends BaseAdapter<TestBean.DateBean> {
    public MyAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_lrecyclerview;
    }

    @Override
    public void onBindItemHolder(ViewHolder holder, int position) {

    }
}
