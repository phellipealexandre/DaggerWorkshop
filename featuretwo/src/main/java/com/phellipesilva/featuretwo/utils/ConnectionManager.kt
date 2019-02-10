package com.phellipesilva.featuretwo.utils

import android.content.Context
import android.net.ConnectivityManager

internal class ConnectionManager(private val context: Context) {

    fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}