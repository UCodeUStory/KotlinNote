package com.wangpos.kotlin_s_mvp

/**
 * Created by qiyue on 2018/4/16.
 */
class TestVar {

    //lateinit不能用在可空的属性上和java的基本类型上
     var age:Int = 0;
    //
    lateinit var name:String

    var name2:String = ""

    var name3:String ?= null

    val name4: String by lazy {
        "sherlbon"
    }


}