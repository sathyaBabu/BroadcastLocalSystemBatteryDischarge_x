package com.sathya.broadcastlocalsystem_x;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;


// telephony sms healthcare ....... Boot AirPlane mode is changed..
public class InstallUninstallReceiver extends BroadcastReceiver {
    // I'm on keen on all broadcast ---- A broadcast can be a VIRUS!!!!

    boolean airPlaneStatus =  false ;

    // He can listen to all the incomming messages including malware virus etc....
    @Override
    public void onReceive(Context context, // proxy
                          Intent intent) {

                            //                    // ACTION_DISCHARGAING
                            //
                            //                           // if (Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())) {
                            //                            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                            //
                            //
                            //                            Log.d("tag"," : "+"Batterylevel:" + Integer.toString(level) + "%");
                            //                            Toast.makeText(context, "Batterylevel:" + Integer.toString(level) + "%", Toast.LENGTH_SHORT).show();

                           //}

                                            String packageName = intent.getData().getSchemeSpecificPart(); //com.edureka.clock




                                                            if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)) { //Intent.ACTION_PACKAGE_ADDED



                                                               // send an sms... That will be the OTP...
                                                                Toast.makeText(context, "Installed " + packageName, Toast.LENGTH_LONG).show();



                                                            }

                                                            if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)) {


                                                                // Taka a pic of the user.. date and tyme store it in shared pref or sql..
                                                                // bring in an Auth activity or a dialog..
                                                                Toast.makeText(context, "Uninstalled  : " + packageName, Toast.LENGTH_LONG).show();
                                                    //                        if( packageName.equalsIgnoreCase("com.sat.asdasdasdasd")){
                                                    //                            // then do your job...
                                                    //                        }
                                                                // shared pref...
                                                                 // Bring in a dialog ask for a pasword...

                                                                // call an activity to verify the password to let user delete the apk...
                                                            }




                                         // this.abortBroadcast(); // comes handy only while declaring it in manifest...

    }


}



//
//intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//        intentFilter.addAction(Intent.ACTION_VIEW);
//