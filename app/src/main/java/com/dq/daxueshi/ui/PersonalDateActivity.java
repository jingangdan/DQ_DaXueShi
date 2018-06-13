package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.dq.daxueshi.R;
import com.dq.daxueshi.adapter.ForumAdapter;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.bean.TestBean;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的-关注（好友、粉丝、关注）-个人资料
 * Created by jingang on 2018/6/8.
 */

public class PersonalDateActivity extends BaseActivity {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private ForumAdapter mAdapter;
    private List<TestBean.DateBean> dateList;

    private View headView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_personal);
        ButterKnife.bind(this);
        setTvTitle("个人资料");
        setIvBack();

        setAdapter();
        initDate();

        setHeadView();
    }

    public void initDate() {
        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));

        lRrcyclerView.refreshComplete(dateList.size());
        mAdapter.addAll(dateList);

    }

    public void setAdapter() {
        mAdapter = new ForumAdapter(this);
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(this));
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                goToActivity(ForumDetailsActivity.class);
            }
        });
    }

    public void setHeadView() {
        headView = LayoutInflater.from(this).inflate(R.layout.include_personal_head, null);
        lRecyclerViewAdapter.addHeaderView(headView);

    }

}
