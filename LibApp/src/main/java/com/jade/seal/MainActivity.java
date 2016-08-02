package com.jade.seal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.m_Image)
    com.facebook.drawee.view.SimpleDraweeView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mImage.setImageURI("http://img2.imgtn.bdimg.com/it/u=2692675169,1336708413&fm=21&gp=0.jpg");
        mImage.setBackgroundResource(R.mipmap.ic_launcher);
    }
}
