package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.dq.daxueshi.R;
import com.dq.daxueshi.adapter.MyAdapter;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.bean.TestBean;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的-消息
 * Created by jingang on 2018/6/8.
 */

public class MsgActivity extends BaseActivity {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private MyAdapter myAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private List<TestBean.DateBean> dateList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.layout_lrecyclerview);
        ButterKnife.bind(this);
        setTvTitle("消息");
        setIvBack();

        setAdapter();
        initDate();
    }

    public void setAdapter() {
        myAdapter = new MyAdapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(myAdapter);
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(this));
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);
    }

    public void initDate() {
        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));

        lRrcyclerView.refreshComplete(dateList.size());
        myAdapter.addAll(dateList);

    }
}
