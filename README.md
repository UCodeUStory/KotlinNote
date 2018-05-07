# KotlinSMVP
Kotlin-MVP

### Kotlin
   - 1. Kotlin 特性
   - - 1. 简洁，在Kotlin中，努力地保证你写的代码都具有实际的意义，而不是仅仅满足代码结构，许多Java样中，如get，set方法，和构造方法参数赋值
   给字段的逻辑，在Kotlin都将是隐式的，并不会是你的代码变得混乱；同时Kotlin支持lambda，让小代码块可以轻松传递给函数库
   。这让你可以办公共部分封装到函数库中，而在用户代码中仅保留特定的针对任务的实现；
   越简洁的代码写起来花的时间更少，更重要读起来耗费的时间也短。这会提高生产力。
   - - 2. 安全 
   - - 3. 互操作性
   
   - 2. 基础
   - - 1. 函数
   - - 2. 语句和表达式
   - - - 1. 在kotlin if 是一个表达式，并不是声明，两者区别，在于，表达式有值他可以作为另一个表达式的一般不分，
         声明没有值，在Java中所有控制结构都是声明，在Kotlin中除了for do while都是表达式
   - - 3. 表达式体的函数更多代替代码块体函数
       
              //一般写法
              fun max(a:Int,b:Int):Int{
                  return if(a>b) a else b;
              }
              // 将代码块主体替换表达式主体
              fun max(a:Int,b:Int):Int = if(a>b) a else b;
          
              // 省略返回值
              fun max(a:Int,b:Int) = if(a>b) a else b;
   - - 4. 变量与常量
   - - - 1. 常量
   
   
                       val name1 = "John"
                       //可以省略类型
                       val name2:String = "Bob"
       
   - - - 2. 变量
   

                       var age1:Int = 23
                       var age2 = 12
   - - 3. 类
       
                //java
                public Person{
                   private final name;
                   
                   public Person(String name){
                       this.name = name;
                   }
                   
                }
                //kotlin
                class Person(var name:String,val age:Int)
                
                //var定义的是可读写属性，val定义的是只读属性，也就相当于没有get方法
                
                //kotlin 中将get 和set方法进行隐藏了，赋值和访问我们只需要通过对象.属性就可以访问
                
                自定义获取器,判断是否是成年人，person.isAdult 
                
                 val isAdult:Boolean
                        get() {
                            return age>18
                        }
                        
                //定义枚举
                
                enum class Color(val r:Int,val g:Int,val b:Int ) {
                
                    RED(255,0,0),ORANGE(255,265,0),YELLOW(255,255,0);
                
                    fun rgb()=(r*256+g)*256 + b;
                }
                
                //when 代替Javaswitch ；else 里面相当于default,因为必须有个返回值
                
                fun test_when(age:Int)= when(age){
                           1->"zhangsan"
                           2->"lisi"
                           3->"wangwu"
                        else -> {
                            "no find"
                        }
                    }
                // 强化java中instance of ，kotlin用is
   
   - - 4. 迭代
   
   
            while 和java用法一样
            
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
   - - 5. 异常
               
               
              
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
   - - 6. 集合
     
     
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
            
                }
            
                @Test
                fun test_map(){
                    var map = mapOf<String,Int>("one" to 1,"two" to 2,"three" to 3)//只读map
                    println(map["two"])
                    for ((key,value) in map){
                        println("key="+key+" value="+value)
                    }
                } 
   - - 7. 指定参数名

                 joinToString(collection = mutableList,separator = ",",prefix = "(",postfix = ")");
              
   - - 8. 指定默认值实现重载
                             
                fun <T>joinToString(collection:Collection<T>,separator:String = ",",prefix:String = "(",postfix:String=")"):String{
                    var result = StringBuilder(prefix)
                    for((index,element) in collection.withIndex()){
                        if (index>0)result.append(separator)
                        result.append(element)
                    }
                    result.append(postfix)
                    return result.toString()
                }
                
                  var str3 :String = joinToString(collection = mutableList)
                  var str4 :String = joinToString(collection = mutableList,separator = "^")
   - - 9. 静态方法
               
                        package util
                        fun getProductName():String{
                            return "KotlinSMVP"
                        }

                        import util.getProductName
   - - 10. 扩展方法
               
                    扩展方法只是静态方法的高效语法，可以指定具体的类型接收器
   
                                                     
        
                    /**
                     * 全部的集合扩展joinString方法
                     */
                    fun <T>Collection<T>.joinString(
                            separator:String = ",",prefix:String = "(",postfix:String=")"
                    ):String{
                        var result = StringBuilder(prefix)
                        for((index,element) in this.withIndex()){
                            if (index>0)result.append(separator)
                            result.append(element)
                        }
                        result.append(postfix)
                        return result.toString()
                    }
                    
                    
                    不可以覆盖的扩展方法，因为扩展函数并不是类一部分，而是属于类的外部，被调函数依赖于已声明的静态类型
                    
   - - 11. 创建接收任意数量的参数方法
           
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
   - - 12. 接口(有默认实现方法和无默认实现方法)
   - - 13. 类(默认作用域是final不可继承)        
   - - - 1. 允许创建子类需要open修饰
   
       
       open class Person (var name:String,val age:Int){
       
           val isAdult:Boolean
               get() {
                   return age>23
               }
       }
   - - - 2. 修饰方法(open可以被重写覆盖 final不可被重写覆盖 abstract必须被重写)    
        
   - - - 3. 可见性(public所有地方可见,internal模块内可见,protect 子类可见，private类内部可见)
   - - 14. 内部类和类嵌套
   - - - 1. inner修饰的类持有外部类引用，同时创建也依赖外部类对象，其他类不持有外部类引用
   
    @Test
    fun test_innerClass(){
        var outTest:OutTest = OutTest();
        println(outTest.getName());
        var innerTest:OutTest.InnerTest =  outTest.InnerTest()
        println(innerTest.getName()+"--"+innerTest.getOurReference().getName())
        var test:OutTest.Test = OutTest.Test();
        println(test.getName())

    }
   - - 15. 密封类（超强的枚举）
   
    /**
        * sealed 密封类 这一好处是，现在when表达式要求我们为所有可能的类型提供分支：
        */
       fun calculate (x:Int,operation: Operation)=when(operation){
   
           is Operation.Add -> x + operation.value
           is Operation.Substract -> x - operation.value
           is Operation.Multiply ->  x * operation.value
           is Operation.Divide -> x/operation.value
       }
   - - 16. 主构造器和初始化器
   - - 17. 委托
   - - - 1. 类委托
   
   
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
   - - -  2. 属性委托
   
   
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
       
        //可以实现的单例模式
        class Example1{
            //lazy 方法只会被调用一次，而且只能作为常量才可以使用，因此适合做单例模式
            val lazyValue: String by lazy {
                println("computed!")     // 第一次调用输出，第二次调用不执行
                "Hello"
            }
    
        }
       
       //可以观察前后值得变化
       class User {
               var name: String by Delegates.observable("初始值") {
                   prop, old, new ->
                   println("旧值：$old -> 新值：$new")
               }
           }
   - - 18. 静态属性和方法
   
           
           class Utils {
           
               companion object {
                   val isDebug:Boolean = false;
           
                   fun test():String{
                       return "Hello"
                   }
               }
           }
   - - 19. 匿名内部类
   
   
          view.setOnClickListener(object:OnClickListener{
               override fun onclick() {
                   println("onclick!")
               }
           })
   - - 20. Lambda
   
   
     @Test
       fun test_lambda(){
           var sum = {a:Int,b:Int ->
               println("a="+a)
               a+b}
           println(sum(10,10))
   
           var index = 1;
           var list = listOf<String>("aaa","bbb");
   
           list.forEach {
               println(index)
               println(it)
           }
       }
   - - 21. 集合通过 filter,map 筛选和修改
        
    @Test
    fun test_list_filter(){
        var list = listOf<String>("aaa","bbb","ccc");
        list.filter { it.equals("aaa") }
        println(list)
    }

    class Tester(val name:String)

    @Test
    fun test_list_map(){
       var list = listOf( Tester("AAA"),Tester("BBB"),Tester("CCC"));
       var targetList = list.map { it.name }// 相当于每一项变成it.name
       println(list)
       println(targetList)

        var numList = listOf(1,2,3,4,5);

        var targetNums = numList.map { it*2 }// 相当于每一项变成it*2

        println(targetNums)
    }

    @Test
    fun test_map_filter(){
        var maps = mapOf<Int,String>(1 to "one",2 to "two")

        var targetMap = maps.filterKeys { it>1 }

        println(targetMap)

        var targetMap2 = maps.filterValues { it.equals("one") }

        println(targetMap2)

    }
    @Test
    fun test_map_map(){
        var maps = mapOf<Int,String>(1 to "one", 2 to "two", 3 to "three")

        var targetmap  = maps.mapKeys { it.key *2 }
        println(targetmap)

        var targetMap2 = maps.mapValues { it.value+"_qy" }

        println(targetMap2)
    }
 - - 22. 集合 all,any,count, find
 
 
    @Test
    fun test_collection_all_any_count_find_groupby(){
         var list = listOf(1 ,2 ,3 ,4 ,5)

         println(list.all { it> 2 })
         println(list.any { it> 2 })
         println(list.find { it > 2 })
         println(list.count { it> 2 })
    }
### Kotlin-Android