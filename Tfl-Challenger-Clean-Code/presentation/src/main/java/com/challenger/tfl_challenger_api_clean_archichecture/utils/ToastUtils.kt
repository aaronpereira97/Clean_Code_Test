package com.challenger.tfl_challenger_api_clean_archichecture.utils

import android.content.Context
import android.widget.Toast

object ToastUtils {

    fun showToastUtils(context:Context, msg: String,  duration:Int){
        Toast.makeText(context, msg, duration).show()
    }
}