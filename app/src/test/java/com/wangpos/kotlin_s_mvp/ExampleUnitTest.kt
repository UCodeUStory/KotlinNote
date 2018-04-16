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
        System.out.println(name4)
    }

//    fun max(a:Int,b:Int):Int{
//        return if(a>b) a else b;
//    }
//
//    fun max(a:Int,b:Int):Int = if(a>b) a else b;

    fun max(a:Int,b:Int) = if(a>b) a else b;

    val name1 = "John"
    //可以省略类型
    val name2:String = "Bob"
    var age1:Int = 23
    var age2 = 12

    val name4: String by lazy {

        "sherlbon"
    }



}
