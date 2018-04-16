package com.wangpos.kotlin_s_mvp.ui

import android.util.Log
import android.widget.ImageView
import com.wangpos.kotlin_s_mvp.R
import com.wangpos.kotlin_s_mvp.base.BaseActivity
import com.wangpos.kotlin_s_mvp.base.BasePresenter
import kotlinx.android.synthetic.main.activity_main.view.*


class WelcomeActivity : BaseActivity<WelcomePresenter>(),WelcomeContract.View{

    val TAG:String = "WelcomeActivity";

    lateinit var ivHeader: ImageView;

    override fun initPresenter() {
        mPresenter = WelcomePresenter(WelcomeModel())
        mPresenter!!.onAttachedView(this)
    }

    override fun initView() {
        ivHeader = findViewById(R.id.ivHeader)
        mPresenter!!.loadHeader();

    }

    override fun getLayout(): Int {
        return R.layout.activity_main;
    }

    override fun onLoadSuccess(id: Int) {
        ivHeader.setImageResource(id);
    }

    override fun onLoadMenuSuccess(id: Int) {
    }





}
