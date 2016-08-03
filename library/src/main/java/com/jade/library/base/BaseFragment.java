package com.jade.library.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jade.library.mvp.BasePresenter;

/**
 * Created by jade on 16-8-3.
 */
public abstract class BaseFragment<V, T extends BasePresenter<V>> extends Fragment {
    protected T mPresenter;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        this.mPresenter = initPresenter();
        this.mPresenter.attach((V) this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return onFragmentCreateView(inflater, container, savedInstanceState);
    }

    @Nullable
    protected abstract View onFragmentCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected abstract T initPresenter();

    @Override
    public void onDetach() {
        this.mPresenter.detach();
        super.onDetach();
    }

}
