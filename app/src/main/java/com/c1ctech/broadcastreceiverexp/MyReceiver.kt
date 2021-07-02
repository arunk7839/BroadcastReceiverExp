package com.c1ctech.broadcastreceiverexp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

// MyReceiver class extending BroadcastReceiver class
class MyReceiver : BroadcastReceiver() {

    //executed when sendBroadcast() is called on button click
    override fun onReceive(context: Context?, intent: Intent?) {

        val data = intent!!.extras!!.getString("data")

        Toast.makeText(context, " Broadcast Received with data " + data, Toast.LENGTH_LONG).show()

    }
}

