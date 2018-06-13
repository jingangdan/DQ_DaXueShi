package com.dq.daxueshi.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
 * 论坛-详情
 * Created by jingang on 2018/6/7.
 */

public class ForumDetailsActivity extends BaseActivity {
    @Bind(R.id.lrvForumDetails)
    LRecyclerView lrvForumDetails;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private List<TestBean.DateBean> dateList;
    private Adapter mAdapter;

    //头布局
    View headView;
    private LinearLayout llContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_forum_details);
        ButterKnife.bind(this);
        setIvBack();
        setTvTitle("详情");

        setAdapter();
        setHeaderView();
        initDate();
    }

    public void setHeaderView() {
        headView = LayoutInflater.from(this).inflate(R.layout.include_forum_details_head, null);
        lRecyclerViewAdapter.addHeaderView(headView);
        llContent = (LinearLayout) headView.findViewById(R.id.lin_forum_details_content);
    }

    public void setAdapter() {
        mAdapter = new Adapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(mAdapter);
        lrvForumDetails.setLayoutManager(new LinearLayoutManager(this));
        lrvForumDetails.setAdapter(lRecyclerViewAdapter);
    }

    public void initDate() {
        dateList = new ArrayList<>();
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));
        dateList.add(new TestBean.DateBean("aaa", "aaa"));

        lrvForumDetails.refreshComplete(dateList.size());
        mAdapter.addAll(dateList);
    }

    //设置内容view
    private void setContentView(TestBean data) {
        llContent.removeAllViews();
//        if (data.getContent() != null && data.getContent().size() > 0) {
//            for (int i = 0; i < data.getContent().size(); i++) {
//                View view = LayoutInflater.from(this).inflate(R.activity_integral.item_skill_details, null);
//                new ContentViewHolder(view, data.getContent().get(i));
//                llContent.addView(view);
//            }
//        }
        for (int i = 0; i < data.getDateBeanList().size(); i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_forum_details_content, null);
            new ContentViewHolder(view, data);
            llContent.addView(view);
        }
    }

//    ArrayList<ImageItem> mDataImage = new ArrayList<>();
//    int picPosition = -1;

    //单项内容布局
    class ContentViewHolder {
        @Bind(R.id.item_skill_details_tv)
        TextView itemSkillDetailsTv;
        @Bind(R.id.item_skill_details_iv)
        ImageView itemSkillDetailsIv;

        public ContentViewHolder(View view, final TestBean item) {
            ButterKnife.bind(this, view);
            if (!TextUtils.isEmpty(item.getName())) {
//                mDataImage.add(new ImageItem("", HttpUrl.IMAGE_URL + item.getStr_imgs()));
//                picPosition++;
//                item.setPicPosition(picPosition);
//
//                if (TextUtils.isEmpty(item.getStr_content())) {
//                    itemSkillDetailsTv.setVisibility(View.GONE);
//                } else {
//                    itemSkillDetailsTv.setVisibility(View.VISIBLE);
//                }
//                itemSkillDetailsIv.setVisibility(View.VISIBLE);
//                //使图片根据高度自适应宽度
//                int screenWidth = WindowUtils.getScreenWidth(SkillDetailsActivity.this); //获得屏幕宽度
//                ViewGroup.LayoutParams lp = itemSkillDetailsIv.getLayoutParams(); //获取布局参数管理器
//                lp.width = screenWidth; //设置宽度为获取屏幕宽度
//                lp.height = WindowManager.LayoutParams.WRAP_CONTENT; //设置宽度为自适应宽度
//
//                itemSkillDetailsIv.setLayoutParams(lp);  //将布局参数设置到控件上
//                GlideUtils.loadImageView(SkillDetailsActivity.this, HttpUrl.IMAGE_URL + item.getStr_imgs(), itemSkillDetailsIv);
//                itemSkillDetailsIv.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //预览
//                        MyPicMethodUtil.preview(SkillDetailsActivity.this, mDataImage, item.getPicPosition());
//                    }
//                });
            }
//            if (!TextUtils.isEmpty(item.getStr_content())) {
//                if (TextUtils.isEmpty(item.getStr_imgs())) {
//                    itemSkillDetailsIv.setVisibility(View.GONE);
//                } else {
//                    itemSkillDetailsIv.setVisibility(View.VISIBLE);
//                }
//                itemSkillDetailsTv.setVisibility(View.VISIBLE);
//                itemSkillDetailsTv.setText(item.getStr_content());
//            }
        }
    }


    public class Adapter extends BaseAdapter<TestBean.DateBean> {
        public Adapter(Context context) {
            super(context);
        }

        @Override
        public int getLayoutId() {
            return R.layout.item_forum_deatails_comment;
        }

        @Override
        public void onBindItemHolder(ViewHolder holder, int position) {

        }
    }
}
