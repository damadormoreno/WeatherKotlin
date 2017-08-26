package com.example.david.weatherkotlin.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by david on 19/08/17.
 */

fun Context.toast(message : CharSequence, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, duration).show()
}