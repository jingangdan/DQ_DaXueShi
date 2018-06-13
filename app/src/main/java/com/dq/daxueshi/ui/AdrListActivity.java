package com.dq.daxueshi.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.base.BaseAdapter;
import com.dq.daxueshi.base.ViewHolder;
import com.dq.daxueshi.bean.TestBean;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 收货地址
 * Created by jingang on 2018/6/9.
 */

public class AdrListActivity extends BaseActivity {
    @Bind(R.id.lRrcyclerView)
    LRecyclerView lRrcyclerView;

    private List<TestBean.DateBean> dateList;
    private Adapter mAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.layout_lrecyclerview);
        ButterKnife.bind(this);
        setTvTitle("收货地址");
        setIvBack();

        setAdapter();
        initDate();
    }

    public void setAdapter() {
        mAdapter = new Adapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lRrcyclerView.setLayoutManager(new LinearLayoutManager(this));
        lRrcyclerView.setAdapter(lRecyclerViewAdapter);
    }

    public void initDate() {
        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
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
            return R.layout.item_adr;
        }

        @Override
        public void onBindItemHolder(ViewHolder holder, int position) {
            ImageView update = holder.getView(R.id.ivItemAdrUpdate);
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToActivity(AdrUpdateActivity.class);
                }
            });
        }
    }
}
