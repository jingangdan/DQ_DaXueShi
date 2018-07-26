package com.dq.daxueshi.ui;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dq.daxueshi.R;
import com.dq.daxueshi.adapter.Adapter;
import com.dq.daxueshi.base.BaseActivity;
import com.jingang.album.Action;
import com.jingang.album.Album;
import com.jingang.album.AlbumFile;
import com.jingang.album.api.widget.Widget;
import com.jingang.album.impl.OnItemClickListener;
import com.jingang.album.widget.divider.Api21ItemDivider;
import com.jingang.album.widget.divider.Divider;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页-发布（图文、视频）-发布
 * Created by jingang on 2018/6/11.
 */

public class PublishPostActivity extends BaseActivity {
    @Bind(R.id.rvPublishPost)
    RecyclerView recyclerView;
    @Bind(R.id.butPublishPostImg)
    Button butPublishPostImg;
    @Bind(R.id.linPublicPostPlate)
    LinearLayout linPublicPostPlate;

    private Adapter mAdapter;
    private ArrayList<AlbumFile> mAlbumFiles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_publish_post);
        ButterKnife.bind(this);
        setTvTitle("发布图文");
        setIvBack();
        getTvRight().setText("发表");
        getTvRight().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("走起");
            }
        });

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        Divider divider = new Api21ItemDivider(Color.TRANSPARENT, 10, 10);
        recyclerView.addItemDecoration(divider);

        mAdapter = new Adapter(this, new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                previewAlbum(position);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    @OnClick({R.id.butPublishPostImg, R.id.linPublicPostPlate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butPublishPostImg:
//                动态请求权限
//                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                            1);
//                } else {
//
//                }
//
//                if (ContextCompat.checkSelfPermission(this,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                        != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this,
//                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                            2);
//                } else {
//                    selectAlbum();
//                }

                selectAlbum();
                break;
            case R.id.linPublicPostPlate:
                goToActivityForResult(PublishPostPlateActivity.class, 100);
                break;
        }
    }

    /**
     * 选择图片（手机本地图库）
     */
    private void selectAlbum() {
        Album.album(this)
                .multipleChoice()
                .columnCount(2)
                .selectCount(6)
                .camera(true)
                .cameraVideoQuality(1)
                .cameraVideoLimitDuration(Integer.MAX_VALUE)
                .cameraVideoLimitBytes(Integer.MAX_VALUE)
                .checkedList(mAlbumFiles)
                .widget(
                        Widget.newDarkBuilder(this)
                                // .title(mToolbar.getTitle().toString())
                                .build()
                )
                .onResult(new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(@NonNull ArrayList<AlbumFile> result) {
                        mAlbumFiles = result;
                        //mAlbumFiles.get(0).getPath();
                        mAdapter.notifyDataSetChanged(mAlbumFiles);
                        // mTvMessage.setVisibility(result.size() > 0 ? View.VISIBLE : View.GONE);
                    }
                })
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(@NonNull String result) {
                        showMessage("Canceled");
                    }
                })
                .start();
    }

    /**
     * 显示图片
     */
    private void previewAlbum(int position) {
        if (mAlbumFiles == null || mAlbumFiles.size() == 0) {
            showMessage("Please select, first.");
        } else {
            Album.galleryAlbum(this)
                    .checkable(true)
                    .checkedList(mAlbumFiles)
                    .currentPosition(position)
                    .widget(
                            Widget.newDarkBuilder(this)
                                    //  .title(mToolbar.getTitle().toString())
                                    .build()
                    )
                    .onResult(new Action<ArrayList<AlbumFile>>() {
                        @Override
                        public void onAction(@NonNull ArrayList<AlbumFile> result) {
                            mAlbumFiles = result;
                            mAdapter.notifyDataSetChanged(mAlbumFiles);
                            //mTvMessage.setVisibility(result.size() > 0 ? View.VISIBLE : View.GONE);
                        }
                    })
                    .start();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectAlbum();
            } else {
                // Permission Denied
                showMessage("Permission Denied");
            }
        }

        if (requestCode == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectAlbum();
            } else {
                // Permission Denied
                showMessage("Permission Denied");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
