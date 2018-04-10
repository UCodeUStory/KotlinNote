package com.wangpos.kotlin_s_mvp.base

import android.os.Parcel
import android.os.Parcelable
import com.wangpos.kotlin_s_mvp.base.task.SmartTaskManager
import java.lang.reflect.ParameterizedType

/**
 * Created by qiyue on 2018/3/12.
 */



/**
 * Created by qiyue on 2016/4/5.
 */
abstract class BaseActivity<M,V,P : BasePresenter<M,V>>: BaseAppCompatActivity() {

    var mPresenter: P? = null;
    protected var smartTaskManager: SmartTaskManager? = null;
}
