package com.wangpos.kotlin_s_mvp.ui

import com.wangpos.kotlin_s_mvp.base.BasePresenter
import android.support.annotation.DrawableRes
import com.wangpos.kotlin_s_mvp.base.BaseModel
import com.wangpos.kotlin_s_mvp.base.BaseView



/**
 * Created by qiyue on 2018/4/11.
 */
interface WelcomeContract {

    interface View : BaseView {
        fun onLoadSuccess(@DrawableRes id: Int)

        fun onLoadMenuSuccess(@DrawableRes id: Int)
    }

    abstract class Model : BaseModel() {

        internal abstract fun findHeader(onLoadHeaderListener: OnLoadHeaderListener)

        internal abstract fun findMenu(onLoadMenuListener: OnLoadMenuListener)

        interface OnLoadHeaderListener {
            fun onLoadSuccess(@DrawableRes id: Int)
        }

        interface OnLoadMenuListener {
            fun onLoadMenuSuccess(@DrawableRes id: Int)
        }
    }

    abstract class Presenter(mModel: Model) : BasePresenter<View, Model>(mModel) {

        internal abstract fun loadHeader()

        internal abstract fun loadMenu()

        override fun onAttached() {}
    }
}