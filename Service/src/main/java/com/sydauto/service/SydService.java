package com.sydauto.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * @author liuchao
 */
public class SydService extends Service {
    public SydService () {
    }

    @Override
    public IBinder onBind (Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate () {
        super.onCreate();

        int pid = android.os.Process.myPid();
        Log.i("SYD_SERVICE", "process:" + pid);
    }
}
