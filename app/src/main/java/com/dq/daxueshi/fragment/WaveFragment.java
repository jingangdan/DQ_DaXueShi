package com.dq.daxueshi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseFragment;

/**
 * 首页（浪界）
 * Created by jingang on 2018/6/5.
 */

public class WaveFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm_wave, null);
        return view;
    }
}
