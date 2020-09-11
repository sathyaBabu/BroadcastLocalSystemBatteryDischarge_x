package com.sathya.broadcastlocalsystem_x;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // this ... UID
        // Is this a part of CTIVITY??  - ANS : NO

/*

<intent-filter>
                <action android:name="custom.broadcast.depak" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
 */

     //  Intent.ACTION_PACKAGE_REMOVED ---> as my system Actions..


       // not in local broadcast..  intent.ACTION_BATTERY_CHANGED
        //   if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)) {
        if(intent.getAction().toString().contains("custom.broadcast.depak")) {

            String message = intent.getStringExtra("message");
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();



            Bundle extras = intent.getExtras();
           // Toast.makeText(context, "In broad cast receiver" + extras.get("message"), Toast.LENGTH_SHORT).show();

            if (extras.containsKey("message")) {

               // System.out.println("Values received..." + extras.get("message"));
                Log.i("sathya", " Values received " + extras.get("message"));

                Toast.makeText(context, "In broad cast receiver : Received... " + extras.get("message"), Toast.LENGTH_SHORT).show();
            }



        }

//        String message = intent.getStringExtra("message");
//        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}