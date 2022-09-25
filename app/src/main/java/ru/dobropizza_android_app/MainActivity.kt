package ru.dobropizza_android_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.webkit.WebView
import android.webkit.WebViewClient


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webViewMain = WebView(this@MainActivity)
        webViewMain.webViewClient = WebViewClient()
        webViewMain.settings.javaScriptEnabled = true
        setContentView(webViewMain)
        webViewMain.loadUrl("file:///android_asset/dobro_hello.gif")
        webViewMain.settings.useWideViewPort = true
        webViewMain.settings.loadWithOverviewMode = true

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
            val intent = Intent(this@MainActivity, EnterScreen::class.java)
            startActivity(intent)
            finish()
        }, 2900)
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}