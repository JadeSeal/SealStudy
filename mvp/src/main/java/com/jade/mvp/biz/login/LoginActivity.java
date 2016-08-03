package com.jade.mvp.biz.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jade.library.base.BaseActivity;
import com.jade.mvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jade on 16-8-3.
 */
public class LoginActivity extends BaseActivity<Contract.View, MainPresenter> implements Contract.View {
    @BindView(R.id.m_name_edit)
    EditText mNameEdit;
    @BindView(R.id.m_pwd_edit)
    EditText mPwdEdit;
    @BindView(R.id.m_login)
    Button mLogin;

    @OnClick(R.id.m_login)
    public void onClick() {
        String name = mNameEdit.getText().toString().trim();
        String password = mPwdEdit.getText().toString().trim();
        mPresenter.login(name, password);
    }

    @Override
    protected void onActivityCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
