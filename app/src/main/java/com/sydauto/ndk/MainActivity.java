package com.sydauto.ndk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sydauto.base.BaseAppCompatActivity;
import com.sydauto.ndk.manager.SydManager;
import com.sydauto.service.DaemonsService;
import com.sydauto.service.SydService;

/**
 * @author liuchao
 */
public class MainActivity extends BaseAppCompatActivity {

    /**
     * 初始化控件
     *
     * @param savedInstanceState 保存的数据
     */
    @Override
    protected void onInitView (Bundle savedInstanceState) {
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(SydManager.getInstance().getJniMessage());

        int pid = android.os.Process.myPid();
        Log.i("MainActivity", "process:" + pid);
        Intent sydIntent = new Intent(SydApplication.getContext(), SydService.class);
        sydIntent.setAction("com.sydauto.service.SydService:remote");
        startService(sydIntent);
        Intent daemonIntent = new Intent(SydApplication.getContext(), DaemonsService.class);
        daemonIntent.setAction("com.sydauto.service.DaemonsService");
        startService(daemonIntent);
    }

    /**
     * 获取布局ID
     *
     * @return 获取布局id
     */
    @Override
    public int getLayoutId () {
        return R.layout.activity_main;
    }

}
