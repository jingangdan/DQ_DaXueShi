package com.dq.daxueshi.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.dq.daxueshi.R;
import com.dq.daxueshi.adapter.ForumAdapter;
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
 * 首页-发布（图文、视频）-发布-选择板块
 * Created by jingang on 2018/6/8.
 */

public class PublishPostPlateActivity extends BaseActivity {
    @Bind(R.id.lrvPublishPostPlate)
    LRecyclerView lrvPublishPostPlate;

    private Adapter mAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private List<TestBean.DateBean> dateList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_publish_post_plate);
        ButterKnife.bind(this);
        setTvTitle("选择板块");
        setIvBack();

        setAdater();
        initDate();
    }

    public void setAdater() {
        mAdapter = new Adapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lrvPublishPostPlate.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        lrvPublishPostPlate.setAdapter(lRecyclerViewAdapter);
        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showMessage("选择 = " + position);
            }
        });
    }

    public void initDate() {
        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));

        lrvPublishPostPlate.refreshComplete(dateList.size());
        mAdapter.addAll(dateList);

    }

    public class Adapter extends BaseAdapter<TestBean.DateBean> {
        public Adapter(Context context) {
            super(context);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_publish_post_plate;
        }

        @Override
        public void onBindItemHolder(ViewHolder holder, int position) {

        }
    }
}
