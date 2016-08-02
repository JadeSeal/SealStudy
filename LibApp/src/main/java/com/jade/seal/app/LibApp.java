package com.jade.seal.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jade.library.Configuration;
import com.jade.library.LibManager;

/**
 * Created by jade on 16-8-2.
 */
public class LibApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration configuration = new Configuration.Builder(this).initFresco().build();
        LibManager.getInstance().init(configuration);
//        Fresco.initialize(getApplicationContext());
    }
}
