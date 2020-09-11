package com.sathya.broadcastlocalsystem_x;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class BatteryChange extends BroadcastReceiver {


            // He can listen to all the incomming messages including malware virus etc....
            @Override
            public void onReceive(Context context, // proxy
                                  Intent intent) {

        // ACTION_DISCHARGAING

                // if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

                // int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);
                // int percentage = Math.round(level / (float) scale * 100);
        Log.d("tag","landed here...");
                Log.d("tag"," : "+"Batterylevel :" + Integer.toString(level) + "%");
                Toast.makeText(context, "Batterylevel:" + Integer.toString(level) + "%", Toast.LENGTH_SHORT).show();


    }


}

