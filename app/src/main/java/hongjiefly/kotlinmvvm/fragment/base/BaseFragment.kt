package hongjiefly.kotlinmvvm.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * 作用：友盟统计Fragment
 * author：王宏杰.
 * date：Created on 2017/12/12.
 */

abstract open class BaseFragment : UmengFragment() {

    var mRootLayout: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (inflater != null) {
            mRootLayout = inflater.inflate(getContentResId(), container,false)
        }
        return mRootLayout    }


    override  fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getIntentData()
        setListener()
    }


    open fun getIntentData() {}

    open fun setListener() {}


    open fun getContentResId(): Int{
        return 0
    }

}