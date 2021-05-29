package com.example.myapplication.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso

fun ImageView.load(imageURL: String, @DrawableRes placeHolder: Int) {
    if (placeHolder == 0)
        Picasso.get().load(imageURL).into(this)
    else
        Picasso.get().load(imageURL).placeholder(placeHolder).into(this)
}

fun Context.isNetworkAvailable(): Boolean {
    val cm =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            ?: return false
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val cap = cm.getNetworkCapabilities(cm.activeNetwork) ?: return false
        return cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val networks = cm.allNetworks
        for (n in networks) {
            val nInfo = cm.getNetworkInfo(n)
            if (nInfo != null && nInfo.isConnected) return true
        }
    } else {
        val networks = cm.allNetworkInfo
        for (nInfo in networks) {
            if (nInfo != null && nInfo.isConnected) return true
        }
    }
    return false
}