package com.zhiyuan3g.jiguang.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2016/7/25.
 */
public class PushBroadcast extends BroadcastReceiver {

    private static final String TAG="TAG";
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle=intent.getExtras();

        //判断接收到的广播
        //获得注册的ID
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())){

                //接收自定义消息
        }else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())){
            System.out.println("接收到了自定义消息，消息内容是："+bundle.getString(JPushInterface.EXTRA_MESSAGE));
            //自定义消息不会展示在通知栏，完全要开发者写代码去处理

            //接收推送的通知
        }else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())){

            System.out.print("收到了通知");

        }else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){

            System.out.print("用户点击打开了通知");

            //在这里可以自己写代码去定义用户点击后的行为
            System.out.print("通知内容："+bundle.getString(JPushInterface.EXTRA_ALERT));

            //打开新的应用程序
            Intent in=new Intent();
            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            in.setAction(bundle.getString(JPushInterface.EXTRA_ALERT));
            context.startActivity(in);

        }else {
            Log.i(TAG,"Unhandled intent-"+intent.getAction());
        }




    }
}
