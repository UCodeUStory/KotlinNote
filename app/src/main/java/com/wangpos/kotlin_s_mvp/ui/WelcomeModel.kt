package com.wangpos.kotlin_s_mvp.ui

import com.wangpos.kotlin_s_mvp.R

/**
 * Created by qiyue on 2018/4/11.
 */
class WelcomeModel: WelcomeContract.Model() {
    override fun findHeader(onLoadHeaderListener: OnLoadHeaderListener) {
       onLoadHeaderListener.onLoadSuccess(R.drawable.yunzhi)
    }

    override fun findMenu(onLoadMenuListener: OnLoadMenuListener) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}