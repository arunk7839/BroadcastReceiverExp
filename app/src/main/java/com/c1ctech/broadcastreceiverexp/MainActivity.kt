package com.c1ctech.broadcastreceiverexp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var br: MyReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating BroadcastReceiver instance
        br = MyReceiver()

        IntentFilter("com.c1ctech.broadcast.CUSTOM_INTENT").also {
            // registering the receiver
            // it parameter which is passed in  registerReceiver() function
            // is the intent filter that we have just created
            registerReceiver(br, it)
        }

        btn_send_broadcast.setOnClickListener {

            Intent().also { intent ->
                intent.setAction("com.c1ctech.broadcast.CUSTOM_INTENT")
                intent.putExtra("data", "Hello World!")
                sendBroadcast(intent)
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        // unregister the BroadcastReceiver
        unregisterReceiver(br)
    }
}
