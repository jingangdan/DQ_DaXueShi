package com.dq.daxueshi.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.base.BaseAdapter;
import com.dq.daxueshi.base.ViewHolder;
import com.dq.daxueshi.bean.TestBean;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的-关注（好友、关注、粉丝、新的朋友）
 * Created by jingang on 2018/6/8.
 */

public class FollowActivity extends BaseActivity {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private Adapter mAdapter;
    private List<TestBean.DateBean> dateList;
    private LRecyclerViewAdapter lRecyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.layout_lrecyclerview);
        ButterKnife.bind(this);

        setTvTitle(getIntent().getStringExtra("type"));
        setIvBack();

        getIvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity(AddFriendsActivity.class);
            }
        });

        setAdapter();
        initDate();
    }

    public void setAdapter() {
        mAdapter = new Adapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(this));
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                goToActivity(PersonalDateActivity.class);
            }
        });
    }

    public void initDate() {
        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));

        lRrcyclerView.refreshComplete(dateList.size());
        mAdapter.addAll(dateList);

    }

    public class Adapter extends BaseAdapter<TestBean.DateBean> {
        public Adapter(Context context) {
            super(context);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_follow;
        }

        @Override
        public void onBindItemHolder(ViewHolder holder, int position) {

        }
    }

}
