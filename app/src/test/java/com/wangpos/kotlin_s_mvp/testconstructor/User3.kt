package com.wangpos.kotlin_s_mvp.testconstructor

/**
 * Created by qiyue on 2018/4/28.
 * 带默认参数
 */
class User3 constructor(_name:String = "zhangsan") {

    lateinit var name:String;

    init {
        this.name = _name;
    }

}