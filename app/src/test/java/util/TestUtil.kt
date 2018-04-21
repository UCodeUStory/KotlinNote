@file:JvmName("TestUtil")
package util

fun getProductName():String{
    return "KotlinSMVP"
}

fun String.lastChar():Char = get(length-1)

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