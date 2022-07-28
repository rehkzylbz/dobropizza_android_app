package ru.dobropizza_android_app

import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient


class IgnoreSSLErrorWebViewClient : WebViewClient() {

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, error: SslError?) {
        handler.proceed() // When an error occurs, ignore and go on
    }

}
