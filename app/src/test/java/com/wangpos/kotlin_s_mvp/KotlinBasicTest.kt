package com.wangpos.kotlin_s_mvp

import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class KotlinBasicTest {
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

    fun test_when(person: Person) {
        if (person is Student){
            person.learn()
        }
        if (person is Teacher){
            person.teach()
        }
    }

    @Test
    fun test_for_up(){
        for(i in 1..100){
            System.out.println("index="+i);
        }
    }

    @Test
    fun test_for_down(){
        for(i in 100 downTo 1 ){
            System.out.println("index="+i);
        }
    }

    @Test
    fun test_for_step(){
        for(i in 1..100 step 2){
            System.out.println("index="+i);
        }
    }

    @Test
    fun test_iterator_map(){
        val binaryReps = TreeMap<Char, String>()
        for (c in 'A'..'F'){//创建字符区间
            val binary = Integer.toBinaryString(c.toInt())  //将 ASCII 码转化成二进制
            binaryReps[c] = binary //根据 key 为c 把 binary 存到 map 中
        }
        for ((letter, binary) in binaryReps){//迭代 map，把 key 和 value 赋值给变量
            println("$letter = $binary")
        }
    }

    @Test
    fun test_in(){
        System.out.println(contains('A'))
        System.out.println(contains('Z'))
    }

    fun contains(c:Char): Boolean {
        if (c in 'A'..'F'){
            return true
        }
        return false;
    }
    @Test
    fun test_exception(){

        throw IllegalArgumentException("非法数字")
    }
    @Test
    fun test_try_catch(){
        try{
            var sum = 1/0;
        }catch (e:Exception){
            System.out.println("异常"+e.localizedMessage);
        }finally {
            System.out.println("finally");
        }
    }

    @Test
    fun test_try_catch_expression(){
        var num = try {
//            Integer.valueOf(11)
//            22
//            1/0
        }catch (e:Exception){

            System.out.println("异常"+e.localizedMessage);
            0//表达式最后一行作为值
        }finally {
            System.out.println("finally");
        }

        System.out.println("num="+num);
    }


}
