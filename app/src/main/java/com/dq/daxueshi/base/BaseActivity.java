package com.dq.daxueshi.base;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dq.daxueshi.R;
import com.dq.daxueshi.utils.ScreenManagerUtils;
import com.dq.daxueshi.utils.ToastUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.xutils.BuildConfig;
import org.xutils.x;


/**
 * 继承了Activity，实现Android6.0的运行时权限检测
 * 需要进行运行时权限检测的Activity可以继承这个类
 *
 * @describe：基础Activity
 * @author：jingang
 * @createdate：2018/03/22
 */

public abstract class BaseActivity extends AutoLayoutActivity {

    private ImageButton title_ibtn_back;//返回按钮
    private TextView title_tv_title;//标题
    private EditText title_et_search;//搜索框
    private TextView title_tv_right;//右侧文字
    private ImageButton title_ibtn_right;//右侧图片
    private FrameLayout base_fl_content;//内容布局
    private RelativeLayout rlTitle;//标题

    /**
     * 需要进行检测的权限数组
     */
    protected String[] needPermissions = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
    };

    private static final int PERMISSON_REQUESTCODE = 0;

    /**
     * 判断是否需要检测，防止不停的弹框
     */
    private boolean isNeedCheck = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

//        StatusUtils.transparencyBar(this); //设置状态栏全透明
//        StatusUtils.StatusBarLightMode(this); //设置白底黑字
       // StatusUtils.with(this).init(getStatusBarHeight(this));

        x.Ext.init(this.getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG);

        ScreenManagerUtils.getInstance().addActivity(this);
        ScreenManagerUtils.setmCurrentActivity(this);
        initBaseView();


    }

    /**
     * 获取状态栏高度
     *
     * @param context context
     * @return 状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }


    private void initBaseView() {
        title_ibtn_back = (ImageButton) findViewById(R.id.title_ibtn_back);
        title_tv_title = (TextView) findViewById(R.id.title_tv_title);
        title_et_search = (EditText) findViewById(R.id.title_et_search);
        title_tv_right = (TextView) findViewById(R.id.title_tv_right);
        title_ibtn_right = (ImageButton) findViewById(R.id.title_ibtn_right);
        base_fl_content = (FrameLayout) findViewById(R.id.base_fl_content);
        rlTitle = (RelativeLayout) findViewById(R.id.viewtitle_rl);
    }

    public void setBaseContentView(int layoutID) {
        View view = LayoutInflater.from(this).inflate(layoutID, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        base_fl_content.addView(view);
    }

    @SuppressLint("WrongConstant")
    public ImageButton getIvBack() {
        title_ibtn_back.setVisibility(View.VISIBLE);
        return title_ibtn_back;
    }

    public RelativeLayout getRlTitle() {
        return rlTitle;
    }

    @SuppressLint("WrongConstant")
    public void setIvBack() {
        title_ibtn_back.setVisibility(View.VISIBLE);
        title_ibtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScreenManagerUtils.getInstance().removeActivity(BaseActivity.this);
            }
        });

        //StatusUtils.with(this).setColor(Color.RED).init(getStatusBarHeight(this));
    }

    @SuppressLint("WrongConstant")
    public TextView getTvTitle() {
        title_tv_title.setVisibility(View.VISIBLE);
        return title_tv_title;
    }

    @SuppressLint("WrongConstant")
    public void setTvTitle(String title) {
        title_tv_title.setVisibility(View.VISIBLE);
        title_tv_title.setText(title != null ? title : "");
        //StatusUtils.addStatusViewWithColor(this, Color.RED, getStatusBarHeight(this));
        //StatusUtils.with(this).setColor(Color.RED).init(getStatusBarHeight(this));
    }

    @SuppressLint("WrongConstant")
    public EditText getEtSearch() {
        title_et_search.setVisibility(View.VISIBLE);
        return title_et_search;
    }

    @SuppressLint("WrongConstant")
    public TextView getTvRight() {
        title_tv_right.setVisibility(View.VISIBLE);
        return title_tv_right;
    }

    public ImageView getIvRight() {
        title_ibtn_right.setVisibility(View.VISIBLE);
        return title_ibtn_right;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            ScreenManagerUtils.getInstance().removeActivity(this);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void showMessage(String message) {
        ToastUtils.getInstance(BaseActivity.this).showMessage(message);
    }

    /**
     * 跳转到指定的activity
     *
     * @param clazz 目标activity
     */
    public void goToActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * 跳转到制定activity（带result）
     *
     * @param clazz
     * @param code
     */
    public void goToActivityForResult(Class clazz, int code) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, code);
    }

    /**
     * 关闭当前页面
     */
    public void finishActivity() {
        ScreenManagerUtils.getInstance().removeActivity(BaseActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.getInstance(BaseActivity.this).toastCancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (Build.VERSION.SDK_INT >= 23
//                && getApplicationInfo().targetSdkVersion >= 23) {
//            if (isNeedCheck) {
//                checkPermissions(needPermissions);
//            }
//        }
    }

    /**
     * @param permissions
     * @since 2.5.0
     */
    private void checkPermissions(String... permissions) {
        try {
            if (Build.VERSION.SDK_INT >= 23
                    && getApplicationInfo().targetSdkVersion >= 23) {
                List<String> needRequestPermissonList = findDeniedPermissions(permissions);
                if (null != needRequestPermissonList
                        && needRequestPermissonList.size() > 0) {
                    String[] array = needRequestPermissonList.toArray(new String[needRequestPermissonList.size()]);
                    Method method = getClass().getMethod("requestPermissions", new Class[]{String[].class,
                            int.class});

                    method.invoke(this, array, PERMISSON_REQUESTCODE);
                }
            }
        } catch (Throwable e) {
        }
    }

    /**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     * @since 2.5.0
     */
    private List<String> findDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissonList = new ArrayList<String>();
        if (Build.VERSION.SDK_INT >= 23
                && getApplicationInfo().targetSdkVersion >= 23) {
            try {
                for (String perm : permissions) {
                    Method checkSelfMethod = getClass().getMethod("checkSelfPermission", String.class);
                    Method shouldShowRequestPermissionRationaleMethod = getClass().getMethod("shouldShowRequestPermissionRationale",
                            String.class);
                    if ((Integer) checkSelfMethod.invoke(this, perm) != PackageManager.PERMISSION_GRANTED
                            || (Boolean) shouldShowRequestPermissionRationaleMethod.invoke(this, perm)) {
                        needRequestPermissonList.add(perm);
                    }
                }
            } catch (Throwable e) {

            }
        }
        return needRequestPermissonList;
    }

    /**
     * 检测是否所有的权限都已经授权
     *
     * @param grantResults
     * @return
     * @since 2.5.0
     */
    private boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(23)
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] paramArrayOfInt) {
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(paramArrayOfInt)) {
                showMissingPermissionDialog();
                isNeedCheck = false;
            }
        }
    }

    /**
     * 显示提示信息
     *
     * @since 2.5.0
     */
    private void showMissingPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.notifyTitle);
        builder.setMessage(R.string.notifyMsg);

        // 拒绝, 退出应用
        builder.setNegativeButton(R.string.cancel,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        builder.setPositiveButton(R.string.setting,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startAppSettings();
                    }
                });

        builder.setCancelable(false);

        builder.show();
    }

    /**
     * 启动应用的设置
     *
     * @since 2.5.0
     */
    private void startAppSettings() {
        Intent intent = new Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }

}
