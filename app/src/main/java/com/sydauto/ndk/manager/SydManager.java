package com.sydauto.ndk.manager;

/**
 * @author liuchao
 */
public class SydManager {
    private static final String TAG = "SydManager";

    private static final byte[] LOCK = new byte[1];

    private static SydManager sInstance;

    static {
        System.loadLibrary("native-lib");
    }

    private SydManager() {
    }

    public static SydManager getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new SydManager();
            }
            return sInstance;
        }
    }

    public native String getJniMessage ();
}
