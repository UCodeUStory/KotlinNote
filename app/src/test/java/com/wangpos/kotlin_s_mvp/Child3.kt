package com.wangpos.kotlin_s_mvp

/**
 * Created by qiyue on 2018/4/25.
 */
class Child3 :Parent2 ,Parent{

    override fun getAge(): Int {
        return 33;
    }

    override fun getName(): String {

        var name = "Child3";

        var p1:String = super<Parent>.getName();

        var p2:String = super<Parent2>.getName();

        return name+"-"+p1+"-"+p2;
    }



}