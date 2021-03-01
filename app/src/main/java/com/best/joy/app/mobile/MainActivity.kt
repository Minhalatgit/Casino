package com.best.joy.app.mobile

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.MainTheme);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        webView.webViewClient = MyBrowser()
        webView.settings.loadsImagesAutomatically = true
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.loadUrl("http://couryli.xyz/landing.php?top=casino&top=10&app")

        refresh.setOnRefreshListener {
            refresh.isRefreshing = false
            webView.reload()
        }
    }

    class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            Log.d("MainActivity", "shouldOverrideUrlLoading called with $url")
            view.loadUrl(url)
            return true
        }
    }
}

