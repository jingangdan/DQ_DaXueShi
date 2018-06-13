package com.dq.daxueshi.base;

import android.app.Application;

import com.jingang.album.Album;
import com.jingang.album.AlbumConfig;

import java.util.Locale;

/**
 * 程序Application
 * Created by jingang on 2018/6/6.
 */

public class BaseApplication extends Application {
    private static Application instance;
    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;

            Album.initialize(AlbumConfig.newBuilder(this)
                    .setAlbumLoader(new MediaLoader())
                    .setLocale(Locale.getDefault())
                    .build()
            );
        }
    }
    public static Application getInstance() {
        return instance;
    }
}
