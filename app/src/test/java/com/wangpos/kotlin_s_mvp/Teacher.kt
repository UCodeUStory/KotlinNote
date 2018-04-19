package com.wangpos.kotlin_s_mvp

/**
 * Created by qiyue on 2018/4/18.
 */
class Teacher(name: String, age: Int) : Person(name, age) {


    fun teach():String{
        return "Teacher"
    }
}