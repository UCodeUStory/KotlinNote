package com.wangpos.kotlin_s_mvp.base



import android.content.Context

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.wangpos.kotlin_s_mvp.R
import com.wangpos.kotlin_s_mvp.utils.SpUtil


abstract class BaseAppCompatActivity : AppCompatActivity(), View.OnClickListener {
    abstract var mContext: Context

    val menuId: Int
        get() = -1

    abstract val layoutId: Int


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootView = layoutInflater.inflate(this.layoutId, null, false)
        this.setContentView(layoutId, rootView)
//        InjectView.bind(this)
        mContext = this
        initPresenter()
        initView()

    }

    protected fun initPresenter() {}


    /**
     * 默认启动,不传递任何参数
     * @param ActivityClass
     */
    protected fun launcher(ActivityClass: Class<*>) {
        startActivity(Intent(this, ActivityClass))
    }


    fun reload() {
        AppCompatDelegate.setDefaultNightMode(if (SpUtil.isNight) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
        //        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
        recreate()
    }

    fun setContentView(layoutResID: Int, rootView: View) {
        val isNotSwipeBack = layoutResID == R.layout.activity_main
        super.setContentView(if (isNotSwipeBack) rootView else getContainer(rootView))
    }

    private fun getContainer(rootView: View): View {
        //notice 可以做子布局，添加包装
        //        View container = getLayoutInflater().inflate(R.layout.activity_base, null, false);
        //        container.addView();
        return rootView
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (-1 != menuId) menuInflater.inflate(menuId, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        MPermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    abstract fun initView()

    override fun onClick(view: View) {

    }


    override fun onDestroy() {
        super.onDestroy()
//        InjectView.unbind(this)
    }

    companion object {

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }
}
