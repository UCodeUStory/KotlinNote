package com.wangpos.kotlin_s_mvp.ui

import android.util.Log
import com.wangpos.kotlin_s_mvp.R
import com.wangpos.kotlin_s_mvp.base.BaseActivity
import com.wangpos.kotlin_s_mvp.base.BasePresenter


class WelcomeActivity : BaseActivity<WelcomePresenter>(),WelcomeContract.View{
    override fun initPresenter() {
        mPresenter = WelcomePresenter();
        mPresenter!!.onAttachedView(this);
    }

    override fun initView() {

        mPresenter!!.loadHeader();

    }

    override fun getLayout(): Int {
        return R.layout.activity_main;
    }

    override fun onLoadSuccess(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadMenuSuccess(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }





}
