package com.wangpos.kotlin_s_mvp

import org.junit.Test

import org.junit.Assert.*
import util.getProductName
import util.lastChar
import java.util.*
import kotlin.collections.ArrayList

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
//            var sum = 1/0;
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

    @Test
    fun test_set(){
         var setTest = hashSetOf<String>()
         setTest.add("set0")
         setTest.add("set1")
         setTest.add("set2")
         println(setTest)
         println("set-size="+setTest.size)
         println(setTest.contains("set0"));
         println(setTest.javaClass);
    }


    @Test
    fun test_list(){
        var listTest = listOf<String>("23","345","wer")//只读list
        println(listTest.size)
        println(listTest)
        println(listTest.javaClass)

        var mutableList: MutableList<String> = arrayListOf();//读写list

        mutableList.add("list0")
        mutableList.add("list1")
        mutableList.add("list2")

        println(mutableList)
        println(mutableList.javaClass)

        mutableList.forEach {
            println(it)
        }

        for (s in mutableList) {
            println(s)
        }

        for (i in 0..mutableList.size-1){
            println("index="+i +"data="+mutableList[i])
        }

        var str :String =  joinToString(mutableList,",","(",")");
        println(str)

        var str2 :String =  joinToString(collection = mutableList,separator = ",",prefix = "(",postfix = ")");
        println(str2)
        var str3 :String = joinToString(collection = mutableList)
        var str4 :String = joinToString(collection = mutableList,separator = "^")
        println(str3)
        println(str4)

    }

    @Test
    fun test_map(){
        var map = mapOf<String,Int>("one" to 1,"two" to 2,"three" to 3)//只读map
        println(map["two"])
        for ((key,value) in map){
            println("key="+key+" value="+value)
        }

        var mutableMap:MutableMap<String,String> = hashMapOf()

        mutableMap.put("one","11")
        mutableMap.put("two","22")
        for ((key,value) in mutableMap){
            println("key=$key"+" value=$value")
        }

    }

    fun <T>joinToString(collection:Collection<T>,separator:String = ",",prefix:String = "(",postfix:String=")"):String{
        var result = StringBuilder(prefix)
        for((index,element) in collection.withIndex()){
            if (index>0)result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    @Test
    fun staticMethodTest(){

        println("ProductName = "+getProductName())
    }

    @Test
    fun test_extend_method(){
        println("Kotlin".lastChar())
        var listTest = listOf<String>("23","345","wer")
        var resultStr = listTest.joinToString("-")
        println(resultStr)
    }

    @Test
    fun test_any_count_param(){
        var list = createList("first","second")
        list.forEach {
            println(it)
        }
    }

    /**
     * 创建接收任意参数数量的方法
     */
    fun <T> createList(vararg params:T):List<T>{
        var list = ArrayList<T>()
        params.forEach {
            list.add(it)
        }

        return list
    }

    //中缀函数
    /**
     * infix函数需要几个条件：
    - 只有一个参数
    - 在方法前必须加infix关键字
    - 必须是成员方法或者扩展方法
     */
    fun test_infix_fun(){
//        val (number,name) = 1 to "one";

        var sum = 1 add 2

        println("sum="+sum)
    }

    infix fun Int.add(x: Int): Int {
        return this + x
    }

    //相当于在String方法里面添加了一个lastChar方法，lastChar方法可以调用所有公开的属性和方法
//    fun String.lastChar():Char = get(length-1)




}
