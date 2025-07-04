package com.example.tododemocompose.util

import android.util.Log

//☑️Extension function for logging debug messages with the caller's class name as the log tag=======
//✅Or you may pass your custom tag name============================================================
fun Any.logD( message: String,tag: String? = null) {
    val tag = tag?.takeIf { it.isNotEmpty() } ?: this::class.java.simpleName
    Log.d(tag, message)

}