package com.android.startup.protectordemo;

import android.app.Application;
import android.widget.Toast;

import com.android.startup.protector.Protector;

/**
 * Created by liuzhao on 2017/9/25.
 */

public class ProtectorApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // custom crashhandler should be seted before you init Protector
        Thread.setDefaultUncaughtExceptionHandler(new TestCrashHandler());
        Protector.getInstance().addTask(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "执行注册逻辑", 1).show();
            }
        }).restart(false).addSynchronousTask(new TestProtectorTask()).init(ProtectorApp.this);
    }
}
