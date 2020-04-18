package com.example.yxys.common;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        initData();
        initUI();
        event();
    }

    protected abstract int layout();

    protected abstract void initData();

    protected abstract void initUI();

    protected abstract void event();

}
