package com.sydauto.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.core.os.HandlerCompat;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuchao
 */
public class BaseApplication extends Application {

    private static Context sContext;

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    Handler mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());

    /**
     * Gets the number of available cores
     * (not always the same as the maximum number of cores)
     */
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    /**
     * Instantiates the queue of Runnables as a LinkedBlockingQueue
     */
    private final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();

    /**
     * Sets the amount of time an idle thread waits before terminating
     */
    private static final int KEEP_ALIVE_TIME = 1;

    /**
     * Sets the Time Unit to seconds
     */
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;


    /**
     * Creates a thread pool manager
     */
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            // Initial pool size
            NUMBER_OF_CORES,
            // Max pool size
            NUMBER_OF_CORES,
            KEEP_ALIVE_TIME,
            KEEP_ALIVE_TIME_UNIT,
            workQueue
    );

    @Override
    public void onCreate () {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext () {
        return sContext;
    }
}
