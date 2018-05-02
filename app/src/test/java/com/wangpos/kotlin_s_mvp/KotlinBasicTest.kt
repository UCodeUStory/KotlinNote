package com.wangpos.kotlin_s_mvp

import org.junit.Test

import org.junit.Assert.*
import util.Utils
import util.getProductName
import util.lastChar
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

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
    @Test
    fun test_infix_fun(){
//        val (number,name) = 1 to "one";

        var sum = 1 add 2

        println("sum="+sum)

        var account = Account()
        account add 10.0
        println(account.balance)
    }

    infix fun Int.add(x: Int): Int {
        return this + x
    }

    class Account {
        var balance = 100.0

        infix fun add(amount: Double) : Unit {
            this.balance = balance + amount
        }
    }

    @Test
    fun test_split(){
        var data:String = "12.23.A-B";
        println(data.split("."))
        println(data.split(".","-"))
        /**
         * [12, 23, A-B]
        [12, 23, A, B]
         */
    }

    @Test
    fun test_string(){
        var str:String = """a.//sd.s/./9811'/sdfdc.""";
        println(str.trimMargin("."))
    }

    //相当于在String方法里面添加了一个lastChar方法，lastChar方法可以调用所有公开的属性和方法
//    fun String.lastChar():Char = get(length-1)

    @Test
    fun test_interace(){
        //notice 创建一个接口有默认实现
        var child:Child = Child()
        println("age="+child.getAge())
        println("name="+child.getName())
//        age=25
//        name=Parent
    }

    @Test
    fun test_interface2(){
        var child:Child2 = Child2();
        println("age="+child.getAge())
        println("name="+child.getName())
        var child3:Child3 = Child3();

        println(child3.getName());
    }

    @Test
    fun test_innerClass(){
        var outTest:OutTest = OutTest();
        println(outTest.getName());
        var innerTest:OutTest.InnerTest =  outTest.InnerTest()
        println(innerTest.getName()+"--"+innerTest.getOurReference().getName())
        var test:OutTest.Test = OutTest.Test();
        println(test.getName())

        //        var innerTest2:OutTest.InnerTest = OutTest.InnerTest(); 这是错误的
    }

    /**
     * sealed 密封类 这一好处是，现在when表达式要求我们为所有可能的类型提供分支：
     */
    fun calculate (x:Int,operation: Operation)=when(operation){

        is Operation.Add -> x + operation.value
        is Operation.Substract -> x - operation.value
        is Operation.Multiply ->  x * operation.value
        is Operation.Divide -> x/operation.value
    }

    /**
     * 委托，类似装饰器模式，相比Java实现一个装饰器模式，需要实现注入对象，并且把每个方法都写出来，
     * 而这里的委托，比较好是有一种继承的效果，只有需要实现的方法写出来就可以，其他的自动委托
     */
    @Test
    fun test_delegate(){
        val b = BaseImpl(10)
        Derived(b).print() // 输出 10
    }
    // 创建接口
    interface Base {
        fun print()
    }

    // 实现此接口的被委托的类
    class BaseImpl(val x: Int) : Base {
        override fun print() { print(x) }
    }

    // 通过关键字 by 建立委托类
    class Derived(b: Base) : Base by b

    /**
     * 委托属性可以达到延迟加载的效果
     */
    @Test
    fun test_delegate_var(){
        val e = Example()
        println(e.p)     // 访问该属性，调用 getValue() 函数
        e.p = "Runoob"   // 调用 setValue() 函数
        println(e.p)
    }

    // 定义包含属性委托的类
    class Example {
        var p: String by Delegate()
    }

    // 委托的类
    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            println("getValue")
            return "$thisRef, 这里委托了 ${property.name} 属性"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("setValue")
            println("$thisRef 的 ${property.name} 属性赋值为 $value")
        }
    }

    //单例 lazy
    @Test
    fun test_lazy(){
        var e = Example1();
        println(e.lazyValue)
        println(e.lazyValue)
    }

    class Example1{
        //lazy 方法只会被调用一次，而且只能作为常量才可以使用，因此适合做单例模式
        val lazyValue: String by lazy {
            println("computed!")     // 第一次调用输出，第二次调用不执行
            "Hello"
        }

    }

    @Test
    fun test_observale(){
        var user = User();
        println("name="+user.name)
        println("name="+user.name)
        user.name = "hello"
        println("name="+user.name)
        user.name = "haha"
        println("name="+user.name)
    }
    //静态类
    @Test
    fun test_static(){
        println(Utils.isDebug)
        println(Utils.test())
    }

    class User {
        var name: String by Delegates.observable("初始值") {
            prop, old, new ->
            println("旧值：$old -> 新值：$new")
        }

    }
    //匿名内部类
    @Test
    fun test_AnonymousInnerClass(){
        var view = View()
        view.setOnClickListener(object:OnClickListener{
            override fun onclick() {
                println("onclick!")
            }
        })

    }

    interface OnClickListener{
        fun onclick()
    }

    class View {

        fun setOnClickListener(onClickListener: OnClickListener){
            onClickListener.onclick()
        }


    }





}

