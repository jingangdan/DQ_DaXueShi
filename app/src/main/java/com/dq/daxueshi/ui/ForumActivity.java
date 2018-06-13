package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.dq.daxueshi.R;
import com.dq.daxueshi.adapter.ForumAdapter;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.bean.TestBean;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 机关-学习交流
 * Created by jingang on 2018/6/6.
 */

public class ForumActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {
    @Bind(R.id.lrvOfficeItem)
    LRecyclerView lrvOfficeItem;

    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private ForumAdapter mAdapter;

    private List<TestBean.DateBean> dateList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_forum);
        ButterKnife.bind(this);

        setTvTitle("学习交流");
        setIvBack();

        setAdapter();
        initDate();
    }

    public void setAdapter() {
        mAdapter = new ForumAdapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lrvOfficeItem.setLayoutManager(new LinearLayoutManager(this));
        lrvOfficeItem.setAdapter(lRecyclerViewAdapter);

    }

    public void initDate(){
        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa","aaa"));
        dateList.add(new TestBean.DateBean("aaa","aaa"));
        dateList.add(new TestBean.DateBean("aaa","aaa"));
        dateList.add(new TestBean.DateBean("aaa","aaa"));
        dateList.add(new TestBean.DateBean("aaa","aaa"));

        lrvOfficeItem.refreshComplete(dateList.size());
        mAdapter.addAll(dateList);

    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
