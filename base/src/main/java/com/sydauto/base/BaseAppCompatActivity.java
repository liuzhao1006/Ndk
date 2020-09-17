package com.sydauto.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author liuchao
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {
    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        onInitView(savedInstanceState);
        onInitData();
    }

    protected void onInitData () {
    }


    /**
     * 初始化控件
     *
     * @param savedInstanceState 保存的数据
     */
    protected abstract void onInitView (Bundle savedInstanceState);

    /**
     * 获取布局ID
     *
     * @return 获取布局id
     */
    public abstract int getLayoutId ();
}