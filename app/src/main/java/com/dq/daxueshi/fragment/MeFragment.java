package com.dq.daxueshi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.base.BaseFragment;
import com.dq.daxueshi.ui.FollowActivity;
import com.dq.daxueshi.ui.ForumAboutActivity;
import com.dq.daxueshi.ui.IntegralActivity;
import com.dq.daxueshi.ui.MsgActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页（我的）
 * Created by jingang on 2018/6/5.
 */
public class MeFragment extends BaseFragment {
    @Bind(R.id.linMeTop)
    LinearLayout linMeTop;
    @Bind(R.id.linMeMenu1)
    LinearLayout linMeMenu1;
    @Bind(R.id.linMeMenu2)
    LinearLayout linMeMenu2;
    @Bind(R.id.linMeMenu3)
    LinearLayout linMeMenu3;
    @Bind(R.id.linMeMenu4)
    LinearLayout linMeMenu4;
    @Bind(R.id.linMeMenu5)
    LinearLayout linMeMenu5;
    @Bind(R.id.linMeMenu6)
    LinearLayout linMeMenu6;
    @Bind(R.id.linMeMenu7)
    LinearLayout linMeMenu7;

    @Bind(R.id.linMeFriends)
    LinearLayout linMeFriends;
    @Bind(R.id.linMeFans)
    LinearLayout linMeFans;
    @Bind(R.id.linMeFollow)
    LinearLayout linMeFollow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_me, null);
        ButterKnife.bind(this, view);
        //setTopMargin();
        return view;
    }

    public void setTopMargin() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(linMeTop.getLayoutParams());
        lp.setMargins(0, BaseActivity.getStatusBarHeight(getActivity()), 0, 0);
        linMeTop.setLayoutParams(lp);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.linMeFriends, R.id.linMeFans, R.id.linMeFollow,
            R.id.linMeMenu1, R.id.linMeMenu2, R.id.linMeMenu3, R.id.linMeMenu4, R.id.linMeMenu5, R.id.linMeMenu6, R.id.linMeMenu7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linMeFriends:
                //好友
                setFollow("好友");
                break;
            case R.id.linMeFans:
                //粉丝
                setFollow("粉丝");
                break;
            case R.id.linMeFollow:
                //关注
                setFollow("关注");
                break;
            case R.id.linMeMenu1:
                //消息
                startActivity(new Intent(getActivity(), MsgActivity.class));
                break;
            case R.id.linMeMenu2:
                //等级
                break;
            case R.id.linMeMenu3:
                //收藏
                setActivity();
                break;
            case R.id.linMeMenu4:
                //我的帖子
                setActivity();
                break;
            case R.id.linMeMenu5:
                //积分
                startActivity(new Intent(getActivity(), IntegralActivity.class));
                break;
            case R.id.linMeMenu6:
                //草稿
                setActivity();
                break;
            case R.id.linMeMenu7:
                //设置
                break;
        }
    }

    public void setActivity() {
        startActivity(new Intent(getActivity(), ForumAboutActivity.class));
    }

    public void setFollow(String type) {
        startActivity(new Intent(getActivity(), FollowActivity.class).putExtra("type", type));
    }
}
