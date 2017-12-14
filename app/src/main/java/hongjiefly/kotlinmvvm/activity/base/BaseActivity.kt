package hongjiefly.kotlinmvvm.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import hongjiefly.kotlinmvvm.R
import io.reactivex.disposables.CompositeDisposable

/**
 * 作用：BaseActivity
 * author：王宏杰.
 * date：Created on 2017/12/13.
 */
abstract open class BaseActivity : ToolBarActivity() {

    var compositeDisposable: CompositeDisposable? = CompositeDisposable()
    var contentResId: Int? = getContentResId()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRootContent()
        getIntentData()
        setListener()
    }

    private fun setRootContent() {
        if (contentResId!! > 0) {
            addContent(contentResId!!)
        } else if (fragment != null) {
            addFragment(fragment!!)
        } else {
            throw NullPointerException("必须实现getContentResId()或者getFragment()方法")
        }
    }


    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.public_layout, fragment)
        transaction.commitAllowingStateLoss()
    }

    open fun getContentResId(): Int{
        return 0
    }

    open fun getIntentData() {}

    open fun setListener() {}


    override fun initTitleBar(builder: HeaderBuilder) {

    }

    protected val fragment: Fragment?
        get() = null


    override fun onDestroy() {
        super.onDestroy()
        if (compositeDisposable != null) {
            compositeDisposable!!.clear()
        }

    }
}
