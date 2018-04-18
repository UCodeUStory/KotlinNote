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
        var person  = Person("ustory",123);

        person.name = "test";
//        person.age = 23; age 为只读属性
        System.out.println("person.name="+person.name)
        System.out.println("person.age="+person.age)
        val result1 = test_when(1)
        var result2 = test_when(10)
        System.out.println("result1="+result1)
        System.out.println("result2="+result2);



    }

    fun test_when(age:Int)= when(age){
           1->"zhangsan"
           2->"lisi"
           3->"wangwu"
        else -> {
            "no find"
        }
    }




}
