package com.wangpos.kotlin_s_mvp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    fun main(args:Array<String>){
        println("Hello,world!")
    }
    @Test
    fun test_kotlin_function(){
        assertEquals(max(1,2),2);
    }

    fun max(a:Int,b:Int):Int{
        return if(a>b) a else b;
    }
}
