package com.sydauto;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.sydauto.service.SydService;

/**
 * @author liuchao
 */
public class SydDaemonsManager {

    private final static String TAG = "SydDaemonsManager";

    private static SydDaemonsManager instance = null;

    private AppCompatActivity daemonActivity;

    private Context mContext;

    private SydDaemonsManager (Context context) {
        mContext = context;
    }

    /**
     * 获取单例类实例
     */
    public static SydDaemonsManager getInstance (Context context) {
        if (instance == null) {
            instance = new SydDaemonsManager(context);
        }
        return instance;
    }

    /**
     * 启动守护 Activity，其实就是一像素大小的流氓 activity
     */
    public void startDaemonActivity () {
        Log.i(TAG, "startCoreProcess: 启动流氓 Activity");
        mContext.startActivity(new Intent(mContext, SydService.class));
    }

    /**
     * 结束流氓的 activity
     */
    public void finishDaemonActivity () {
        Log.i(TAG, "startCoreProcess: 结束流氓 Activity");
        if (daemonActivity != null) {
            daemonActivity.finish();
        }
    }

    /**
     * 启动核心进程
     */
    public void startCoreProcess () {
        Log.i(TAG, "startCoreProcess: 启动核心进程");
        Intent wakeIntent = new Intent(mContext, SydService.class);
        mContext.startService(wakeIntent);
    }

    /**
     * 保存当前启动的一像素 Activity
     */
    public void setDaemonActivity (AppCompatActivity daemonActivity) {
        this.daemonActivity = daemonActivity;
    }
}
