package com.wangpos.kotlin_s_mvp

/**
 * Created by qiyue on 2018/4/17.
 */
open class Person (var name:String,val age:Int){

    val isAdult:Boolean
        get() {
            return age>23
        }
}