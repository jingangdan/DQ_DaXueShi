package com.dq.daxueshi.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dq.daxueshi.Interface.OnItemClickListener;
import com.dq.daxueshi.R;
import com.dq.daxueshi.adapter.OfficeAdapter;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.base.BaseAdapter;
import com.dq.daxueshi.base.BaseFragment;
import com.dq.daxueshi.base.ViewHolder;
import com.dq.daxueshi.bean.TestBean;
import com.dq.daxueshi.ui.ForumActivity;
import com.dq.daxueshi.ui.SearchActivity;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页（机关）
 * Created by jingang on 2018/6/5.
 */

public class OfficeFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {
    @Bind(R.id.linFmTop)
    RelativeLayout linFmTop;
    @Bind(R.id.tv_fm_top_title)
    TextView tvFmTopTitle;
    @Bind(R.id.rvOffice)
    RecyclerView rvOffice;
    @Bind(R.id.lrvOffice)
    LRecyclerView lrvOffice;
    @Bind(R.id.ib_fm_top_right)
    ImageButton ibFmTopRight;
    private OfficeAdapter mAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_office, null);
        ButterKnife.bind(this, view);
        setTopMargin();
        tvFmTopTitle.setText("机关");
        ibFmTopRight.setVisibility(View.VISIBLE);
        ibFmTopRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });

        setAdapter();
        return view;
    }

    public void setTopMargin() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(linFmTop.getLayoutParams());
        lp.setMargins(0, BaseActivity.getStatusBarHeight(getActivity()), 0, 0);
        linFmTop.setLayoutParams(lp);
    }

    public void initDate() {

    }

    public void setAdapter() {
        lrvOffice.setOnLoadMoreListener(this);
        lrvOffice.setOnRefreshListener(this);

        mAdapter = new OfficeAdapter(getActivity());
        rvOffice.setLayoutManager(new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false));
        rvOffice.setAdapter(mAdapter);

        lrvOffice.setLayoutManager(new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false));
        lrvOffice.setAdapter(new LRecyclerViewAdapter(new Adapter(getActivity())));
//        lRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//        });

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(getActivity(), ForumActivity.class));
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @OnClick(R.id.ib_fm_top_right)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), SearchActivity.class));
    }


    public class Adapter extends BaseAdapter<TestBean.DateBean> {

        public Adapter(Context context) {
            super(context);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_office;
        }

        @Override
        public void onBindItemHolder(ViewHolder holder, int position) {

        }
    }
}
