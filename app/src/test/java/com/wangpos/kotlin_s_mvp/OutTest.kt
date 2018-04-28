package com.wangpos.kotlin_s_mvp

/**
 * Created by qiyue on 2018/4/28.
 */
class OutTest {

    fun getName():String{
        return "OutTest"
    }

    class Test{
        fun getName():String{
            return "Test";
        }
    }

    inner class InnerTest{

        fun getName():String{
            return "InnerTest";
        }
        fun getOurReference():OutTest{
            return this@OutTest;
        }
    }
}