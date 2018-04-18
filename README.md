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
   - - - 3. 类
   
            
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
### Kotlin-Android