package com.ar.callmanager.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by 22716832 on 5/19/16.
 */
public class CallReceiver extends BroadcastReceiver {


    Context mContext;
    TelephonyManager mTelephonyManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        mTelephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        Log.d("Receiver", "CALL_STATE_IDLE");

        Bundle bundle = intent.getExtras();

        mTelephonyManager.listen(mPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    private final PhoneStateListener mPhoneStateListener = new PhoneStateListener() {

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            switch (state) {

                case TelephonyManager.CALL_STATE_IDLE: {
                    Log.d("Receiver", "CALL_STATE_IDLE");
                    break;
                }
                case TelephonyManager.CALL_STATE_RINGING: {
                    /*ContactManager callManagerDatabase = new ContactManager(mContext);
                    SQLiteDatabase db = callManagerDatabase.getWritableDatabase();
                    callManagerDatabase.insertCallInfo(incomingNumber,"");
                    Log.d("Receiver", "CALL_STATE_RINGING");*/
                    break;
                }

            }


        }
    };
}
