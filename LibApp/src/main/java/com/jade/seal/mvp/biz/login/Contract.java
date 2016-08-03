package com.jade.seal.mvp.biz.login;

import com.jade.library.mvp.BasePresenter;
import com.jade.library.mvp.BaseView;

/**
 * Created by jade on 16-8-3.
 */
public interface Contract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

        void login(String name, String password);
    }
}
