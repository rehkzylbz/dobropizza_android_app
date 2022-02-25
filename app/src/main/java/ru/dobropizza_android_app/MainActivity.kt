package ru.dobropizza_android_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = getString(R.string.default_notification_channel_id)
            val channelName = getString(R.string.default_notification_channel_name)
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(NotificationChannel(channelId,
                channelName, NotificationManager.IMPORTANCE_LOW))
        }

        intent.extras?.let {
            for (key in it.keySet()) {
                val value = intent.extras?.get(key)
                Log.d(TAG, "Key: $key Value: $value")
            }
        }

        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}