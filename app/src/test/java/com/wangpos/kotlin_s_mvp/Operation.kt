package com.wangpos.kotlin_s_mvp

/**
 * Created by qiyue on 2018/4/28.
 */
sealed class Operation {
      class Add(val value: Int) : Operation()
      class Substract(val value: Int) : Operation()
      class Multiply(val value: Int) : Operation()
      class Divide(val value: Int) : Operation()
}