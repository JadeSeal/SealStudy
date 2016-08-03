package com.jade.mvp.biz.login;

/**
 * Created by jade on 16-8-3.
 */
public class MainPresenter implements Contract.Presenter {
    private Contract.View mView;

    @Override
    public void attach(Contract.View view) {
        mView = view;
    }

    @Override
    public void detach() {
        mView = null;
    }


    @Override
    public void login(String name, String password) {
        mView.showToast(name + "  " + password);
    }
}
