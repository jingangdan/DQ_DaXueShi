package com.dq.daxueshi.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dq.daxueshi.R;
import com.dq.daxueshi.base.BaseActivity;
import com.dq.daxueshi.fragment.HomeFragment;
import com.dq.daxueshi.fragment.MeFragment;
import com.dq.daxueshi.fragment.OfficeFragment;
import com.dq.daxueshi.fragment.WaveFragment;
import com.dq.daxueshi.utils.ScreenManagerUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Bind(R.id.main_fl_content)
    FrameLayout mainFlContent;
    @Bind(R.id.main_iv_1)
    ImageView mainIv1;
    @Bind(R.id.main_tv_1)
    TextView mainTv1;
    @Bind(R.id.main_ll_1)
    LinearLayout mainLl1;
    @Bind(R.id.main_iv_2)
    ImageView mainIv2;
    @Bind(R.id.main_tv_2)
    TextView mainTv2;
    @Bind(R.id.main_ll_2)
    LinearLayout mainLl2;
    @Bind(R.id.main_iv_3)
    ImageView mainIv3;
    @Bind(R.id.main_ll_3)
    LinearLayout mainLl3;
    @Bind(R.id.main_iv_4)
    ImageView mainIv4;
    @Bind(R.id.main_tv_4)
    TextView mainTv4;
    @Bind(R.id.main_ll_4)
    LinearLayout mainLl4;
    @Bind(R.id.main_iv_5)
    ImageView mainIv5;
    @Bind(R.id.main_iv_red_dot)
    ImageView mainIvRedDot;
    @Bind(R.id.main_rl_5)
    RelativeLayout mainRl5;
    @Bind(R.id.main_tv_5)
    TextView mainTv5;
    @Bind(R.id.main_ll_5)
    LinearLayout mainLl5;
    @Bind(R.id.main_ll_bottom)
    LinearLayout mainLlBottom;

    private HomeFragment homeFragment;
    private OfficeFragment officeFragment;
    private WaveFragment waveFragment;
    private MeFragment meFragment;
    private Fragment[] fragments;

    private int index = 0;//点击的页卡索引
    private int currentTabIndex = 0;//当前的页卡索引
    private long exitTime = 0;//记录上次点击返回按钮的时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    public void initData() {
        homeFragment = new HomeFragment();
        officeFragment = new OfficeFragment();
        waveFragment = new WaveFragment();
        meFragment = new MeFragment();
        fragments = new Fragment[]{homeFragment, officeFragment, waveFragment, meFragment};
        setBottomColor();
        getSupportFragmentManager().beginTransaction().add(R.id.main_fl_content, fragments[index]).show(fragments[index]).commit();
    }

    /**
     * 控制fragment的变化
     */
    public void fragmentControl() {
        if (currentTabIndex != index) {
            removeBottomColor();
            setBottomColor();

            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.main_fl_content, fragments[index]);
            }
            trx.show(fragments[index]).commit();
            currentTabIndex = index;
        }
    }

    /**
     * 设置底部栏按钮变色
     */
    private void setBottomColor() {
        switch (index) {
//            case 0:
//                mainIv1.setImageResource(R.mipmap.tab_home_selected);
//                mainTv1.setTextColor(getResources().getColor(R.color.c_269ceb));
//                break;
//            case 1:
//                mainIv2.setImageResource(R.mipmap.tab_find_selected);
//                mainTv2.setTextColor(getResources().getColor(R.color.c_269ceb));
//                break;
//            case 2:
//                mainIv4.setImageResource(R.mipmap.tab_forum_selected);
//                mainTv4.setTextColor(getResources().getColor(R.color.c_269ceb));
//                break;
//            case 3:
//                mainIv5.setImageResource(R.mipmap.tab_mine_selected);
//                mainTv5.setTextColor(getResources().getColor(R.color.c_269ceb));
//                break;
        }
    }

    /**
     * 清除底部栏颜色
     */
    private void removeBottomColor() {
        switch (currentTabIndex) {
//            case 0:
//                mainIv1.setImageResource(R.mipmap.tab_home_unselected);
//                mainTv1.setTextColor(getResources().getColor(R.color.c_666666));
//                break;
//            case 1:
//                mainIv2.setImageResource(R.mipmap.tab_find_unselected);
//                mainTv2.setTextColor(getResources().getColor(R.color.c_666666));
//                break;
//            case 2:
//                mainIv4.setImageResource(R.mipmap.tab_forum_unselected);
//                mainTv4.setTextColor(getResources().getColor(R.color.c_666666));
//                break;
//            case 3:
//                mainIv5.setImageResource(R.mipmap.tab_mine_unseleected);
//                mainTv5.setTextColor(getResources().getColor(R.color.c_666666));
//                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                showMessage("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                ScreenManagerUtils.getInstance().finishAllActivityAndClose();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.main_ll_1, R.id.main_ll_2, R.id.main_ll_3, R.id.main_ll_4, R.id.main_ll_5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_ll_1:
                //大学市
                index = 0;
                fragmentControl();
                break;
            case R.id.main_ll_2:
                //机关
                index = 1;
                fragmentControl();
                break;
            case R.id.main_ll_3:
                //发布
                goToActivity(PublishActivity.class);
                overridePendingTransition(R.anim.anim_in, 0);
                break;
            case R.id.main_ll_4:
                //浪界
                index = 2;
                fragmentControl();
                break;
            case R.id.main_ll_5:
                //我的
                index = 3;
                fragmentControl();
                break;
        }
    }
}
