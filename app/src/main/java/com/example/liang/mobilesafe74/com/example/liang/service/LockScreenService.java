package com.example.liang.mobilesafe74.com.example.liang.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.example.liang.mobilesafe74.engine.ProcessInfoProvider;

public class LockScreenService extends Service {
    private IntentFilter intentFilter;
    private InnerReceiver innerReceiver;

    public LockScreenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        //锁屏action
         intentFilter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
         innerReceiver = new InnerReceiver();
         registerReceiver(innerReceiver,intentFilter);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private class InnerReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            //清理手机正在运行的进程
            ProcessInfoProvider.killAllProcess(context);
        }
    }
}
