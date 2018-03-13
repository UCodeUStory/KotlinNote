package com.wangpos.kotlin_s_mvp.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.wangpos.kotlin_s_mvp.base.BaseActivity

/**
 * Created by qiyue on 2018/3/12.
 */
object SpUtil {

    internal lateinit var prefs: SharedPreferences

    val isNight: Boolean
        get() = prefs.getBoolean("isNight", false)

    fun getDataByKey(key: String): String {
        return prefs.getString(key, "")
    }

    fun init(context: Context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setNight(context: Context, isNight: Boolean) {
        prefs.edit().putBoolean("isNight", isNight).apply()
        if (context is BaseActivity<*>)
            (context as BaseActivity<*>).reload()
    }

    fun getData(key: String): String {
        return prefs.getString(key, "")
    }

    fun setData(key: String, data: String) {
        prefs.edit().putString(key, data).apply()
    }
}
