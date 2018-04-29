package com.wangpos.kotlin_s_mvp.testconstructor

/**
 * Created by qiyue on 2018/4/28.
 * 单例模式
 */
class User4 private constructor() {

    public fun getInstance():User4{
        return User4();
    }
}