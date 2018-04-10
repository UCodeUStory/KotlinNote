package com.wangpos.kotlin_s_mvp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import com.wangpos.kotlin_s_mvp.base.BaseActivity
import com.wangpos.kotlin_s_mvp.model.TestModel
import com.wangpos.kotlin_s_mvp.model.TestPresenter
import com.wangpos.kotlin_s_mvp.model.TestView

class MainActivity : BaseActivity<TestModel, TestView, TestPresenter>() {

    /**
     * 这个会在属性使用的时候被调用来完成初始化
     */
    override val layoutId: Int
        get() = R.layout.activity_main //To change initializer of created properties use File | Settings | File Templates.

    override fun initView() {
        Log.i("qiyue","test")
    }


}
