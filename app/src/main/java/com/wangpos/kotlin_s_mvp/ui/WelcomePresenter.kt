package com.wangpos.kotlin_s_mvp.ui

/**
 * Created by qiyue on 2018/4/11.
 */
class WelcomePresenter(mModel: WelcomeContract.Model) : WelcomeContract.Presenter(mModel) {

    override fun loadHeader() {
        mModel.findHeader(object:WelcomeContract.Model.OnLoadHeaderListener{
            override fun onLoadSuccess(id: Int) {
                mView!!.onLoadSuccess(id);
            }
        })
    }

    override fun loadMenu() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}