package com.dq.daxueshi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dq.daxueshi.R;
import com.dq.daxueshi.adapter.SimpleFragmentPagerAdapter;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.base.BaseFragment;
import com.dq.daxueshi.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页（大学市）
 * Created by jingang on 2018/6/5.
 */

public class HomeFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    @Bind(R.id.relHomeTop)
    RelativeLayout relHomeTop;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.noScrollViewPage)
    NoScrollViewPager noScrollViewPage;

    private String[] titles = new String[]{"关注", "推荐"};
    private List<Fragment> fragments = new ArrayList<>();
    private SimpleFragmentPagerAdapter sfpAdapter;
    private int page = 0;

    private HomeForumFragment homeForumFragment;
    private String type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_home, null);
        ButterKnife.bind(this, view);
        setTopMargin();

        setFragment(page);

        return view;
    }

    public void setTopMargin() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(relHomeTop.getLayoutParams());
        lp.setMargins(0, BaseActivity.getStatusBarHeight(getActivity()), 0, 0);
        relHomeTop.setLayoutParams(lp);
    }

    public void setFragment(int page) {
        for (int i = 0; i < titles.length; i++) {
            if (i == 0) {
                type = "关注";
            }
            if (i == 1) {
                type = "推荐";
            }
            homeForumFragment = new HomeForumFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            homeForumFragment.setArguments(bundle);
            fragments.add(homeForumFragment);
        }
        sfpAdapter = new SimpleFragmentPagerAdapter(getActivity().getSupportFragmentManager(), getActivity(), fragments, titles);
        noScrollViewPage.setAdapter(sfpAdapter);

        noScrollViewPage.setCurrentItem(page);
        noScrollViewPage.setOffscreenPageLimit(titles.length);

        noScrollViewPage.setOnPageChangeListener(this);
        tabLayout.setupWithViewPager(noScrollViewPage);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
