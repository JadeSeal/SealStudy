package com.jade.greendao.biz.db.presenter;

import com.jade.greendao.biz.db.contract.MainContract;

/**
 * Created by jade on 16-8-4.
 */
public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;

    @Override
    public void attach(MainContract.View view) {
        mView = view;
    }

    @Override
    public void detach() {
        mView = null;
    }
}
