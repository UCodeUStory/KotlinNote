package com.wangpos.kotlin_s_mvp.testconstructor

/**
 * Created by qiyue on 2018/4/28.
 */
class User5 () {

    lateinit var name:String;

    constructor(_name:String):this(){
        this.name = _name;

    }



    // 对象之间的== 是调用的equals方法
    override fun equals(other: Any?): Boolean {

        if(other ==null || other !is User5){
            return false;
        }
        return name.equals(other.name)

    }
}