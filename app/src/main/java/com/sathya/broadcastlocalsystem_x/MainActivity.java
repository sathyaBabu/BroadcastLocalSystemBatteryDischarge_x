package com.sathya.broadcastlocalsystem_x;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
//import android.support.v4.content.LocalBroadcastManager;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private InstallUninstallReceiver  installUninstallReceiver;
    private CustomBroadcastReceiver   customBroadcastReceiver;
    private BatteryChange             batteryChangeMonitor;

    /*
         Books Accounts :

         Bill 123  Amt  800  : Post this bill to a LedgerActivity Then we  need to post the same to
                               PL_Ac_bookActivity   pass it to BALSHEETActivity



     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // Intent.ACTION_AIRPLANE_MODE_CHANGED
       // Intent.ACTION_BOOT_COMPLETED
      //  Intent.ACTION_PACKAGE_REMOVED



        // Butter Knife.. MVVM View Binders...

        Button registerLocalButton       = (Button) findViewById(R.id.registerLocalButton);
        Button unregisterLocalButton     = (Button) findViewById(R.id.unregisterLocalButton);

        Button registerSystemButton      = (Button) findViewById(R.id.registerSystemButton);
        Button unregisterSystemButton    = (Button) findViewById(R.id.unregisterSystemButton);


        Button registerBatteryChanged     = (Button) findViewById(R.id.batterychangedButton);

        Button sendLocalBroadcastButton  = (Button) findViewById(R.id.sendLocalBroadcastButton);

        registerLocalButton.      setOnClickListener(this);
        unregisterLocalButton.    setOnClickListener(this);
        registerSystemButton.     setOnClickListener(this);
        unregisterSystemButton.   setOnClickListener(this);
        sendLocalBroadcastButton. setOnClickListener(this);

        registerBatteryChanged.   setOnClickListener(this);

    //    Intent.ACTION_PACKAGE_REMOVED



    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            /*
                Local Broad cast : Main activity can broadcast a message to all the other activity in the same
                process boundry ( well with in our app )

            */

//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.edureka.co"));
//            startActivity(intent);

            // am start (   ' above stuff   ' )
            case R.id.registerLocalButton:   // Out dated use Live Data Instead...
                registerLocalBroadcast();
                break;
            case R.id.unregisterLocalButton:
                unregisterLocalBroadcast();
                break;


          // This is across the process boundry - with diffrent apk.

            case R.id.registerSystemButton:
                registerSystemBroadcast();
                break;
            case R.id.unregisterSystemButton:
                unregisterSystemBroadcast();
                break;




            case R.id.sendLocalBroadcastButton:
                sendLocalBroadcast();
                break;

            case  R.id.batterychangedButton:
                batteryStatusMonitor();

                break;
        }
    }

  private  void batteryStatusMonitor() {


        Toast.makeText(this, "batteryStatusMonitor is fired", Toast.LENGTH_SHORT).show();
        Log.d("tag","Landed in batteryStatusMonitor");
        /////////



        // i'm intrested in listining to some one..


//                    installUninstallReceiver    = new InstallUninstallReceiver();  // this is my receiving class...
//
//                    IntentFilter intentFilter = new IntentFilter();  // Craeting intent filter dynamically..
//
//                    intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
//                    registerReceiver(installUninstallReceiver, intentFilter);
        /////////////////////
      batteryChangeMonitor    = new BatteryChange();  // this is my receiving class...
        IntentFilter BatteryintentFilter = new IntentFilter();  // Craeting intent filter dynamically..
        BatteryintentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        registerReceiver(batteryChangeMonitor, BatteryintentFilter);

    }

    private void registerLocalBroadcast() {

        // Remember this broad cast will be well with in our activity's in the local sand box...


          // How to receive a broad cast ???
        customBroadcastReceiver = new CustomBroadcastReceiver();

        IntentFilter intentFilter = new IntentFilter(); // this will carry our own actions and data...

        intentFilter.addAction("custom.broadcast.depak");  // instead of Intent.ACTION_DIAL : we r using our signature

//  <action android:name="sathya" />
        LocalBroadcastManager.getInstance(this).registerReceiver(customBroadcastReceiver, intentFilter);

    }

    private void unregisterLocalBroadcast() {
        if (customBroadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(customBroadcastReceiver);
            customBroadcastReceiver = null;
        }
    }
// He is the broadcasting agent...

    private void sendLocalBroadcast() {

        Intent intent = new Intent();
        intent.setAction("custom.broadcast.depak");// Set the action

        intent.putExtra("message", "This is a Sub MSG packet..Sathya");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);  // Fire the action via intent
/// adb shell am broadcast -a "sathya" -n  com.edu.edubroadcastreceiver/.MyReceiver

        // am start -a android.intent.action.VIEW -d http://developer.android.com

        // State of the Intent is changed..
    }

    private void registerSystemBroadcast() {


        // i'm intrested in listining to some one..


        installUninstallReceiver    = new InstallUninstallReceiver();  // this is my receiving class...
        // We have to reg. ourselves.. with the intent filters - or package manager indirectly..


        // creating an Intent Filter Object..
     //Intent.ACTION_DIAL

        /*
        <intent-filter>
                <action android:name="android.intent.action.DIAL" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
         */
        IntentFilter intentFilter = new IntentFilter();  // Craeting intent filter dynamically..
        // Intent filter is also a part of the package manager..

//
//        Intent.ACTION_DIAL
//                Intent.ACTION_VIEW


     //   <action android:name="android.intent.acton.VIEW" />


        // remember every action has a datSchema attached to it..
//        intentFilter.addAction(Intent.ACTION_VIEW);
//        intentFilter.addAction(Intent.ACTION_DIAL);   // Service Get the call date time duration and send the same to server...
//                                                       // enable GEO locations...
                                                        // all the above info is sent to the server so that you can access it through your cell..


        // remember every action has a datSchema attached to it..

        //   <action android:name="android.intent.action.ACTION_BATTERY_CHANGED" />

        // we are adding the action at the run time...

       // intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

          // intentFilter.addAction(Intent.ACTION);



        //  <action android:name="android.intent.action.DIAL" />




                            intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
                            intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
                            intentFilter.addAction(Intent.ACTION_PACKAGE_CHANGED);

                            intentFilter.addDataScheme("package");  /// VERY IMP.. tel:   http:   geo:

                                          //  intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);


      //  intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

// java.lang.RuntimeException: Error receiving broadcast Intent
// { act=android.intent.action.BATTERY_CHANGED flg=0x60000010 (has extras) }
// in com.sathya.broadcastlocalsystem_x.InstallUninstallReceiver@85cab69
//




        // when ever there is a change in the intent filter inform that to installUninstallReceiver
        registerReceiver(installUninstallReceiver, intentFilter);




    }

    private void unregisterSystemBroadcast() {

        if (installUninstallReceiver != null) {

            unregisterReceiver(installUninstallReceiver);  // installUninstallReceiver will disconnect from the BroadcastReceiver..
            installUninstallReceiver = null;




        }
        if (batteryChangeMonitor != null) {

            unregisterReceiver(batteryChangeMonitor);  // installUninstallReceiver will disconnect from the BroadcastReceiver..
            batteryChangeMonitor = null;




        }
    }


}
/*
IntentFilter[] filters=new IntentFilter[1];
  IntentFilter filter=new IntentFilter(Intent.ACTION_VIEW);
  filter.addDataScheme("http");
  filters[0]=filter;
  return new DefaultNotifier(this,NOTIFICATION_ID,filters,new Intent(this,Notification.class),
  R.drawable.anki,R.string.notify_ticker,R.string.notify_title,R.string.notify_message);
 */