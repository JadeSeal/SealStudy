package com.jade.library;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by jade on 16-8-2.
 */
public class Configuration {

    private final Application mApp;
    private final Context mContext;

    private Configuration(final Builder builder) {
        mApp = builder.app;
        mContext = builder.context;
    }

    public static class Builder {
        private Context context;
        private Application app;

        public Builder(Application application) {
            this.app = application;
            this.context = app.getApplicationContext();
        }

        public Builder(Context context) {
            this.context = context;
        }

        public Builder initFresco() {
            if (app != null) {
                Fresco.initialize(app.getApplicationContext());
            } else {
                Fresco.initialize(context);
            }
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }
    }
}
