package com.wangpos.kotlin_s_mvp

/**
 * Created by qiyue on 2018/4/18.
 */
enum class Color(val r:Int,val g:Int,val b:Int ) {

    RED(255,0,0),ORANGE(255,265,0),YELLOW(255,255,0);

    fun rgb()=(r*256+g)*256 + b;
}