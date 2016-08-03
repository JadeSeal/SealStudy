package com.jade.library.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jade.library.mvp.BasePresenter;

/**
 * Created by jade on 16-8-3.
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    protected T mPresenter;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
        this.mPresenter = initPresenter();
        this.mPresenter.attach((V) this);
        onActivityCreate(savedInstanceState);
    }

    protected abstract void onActivityCreate(Bundle savedInstanceState);

    protected abstract T initPresenter();

    @Override
    protected void onDestroy() {
        this.mPresenter.detach();
        super.onDestroy();
    }
}
