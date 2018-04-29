package com.wangpos.kotlin_s_mvp.testconstructor

/**
 * Created by qiyue on 2018/4/28.
 * 通过init初始化
 */
class User2 constructor(_name:String) {

    lateinit var name:String;

    init {
        this.name = _name;
    }
}