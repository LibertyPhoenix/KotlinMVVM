package hongjiefly.kotlinmvvm.activity

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import hongjiefly.kotlinmvvm.R
import kotlinx.android.synthetic.main.activity_toolbar.*


/**
 * ToolBarActivity
 * author: 王宏杰
 * date: Created on 17/12/12.
 */
abstract class ToolBarActivity : UmengActivity() {

    protected lateinit var mHeaderBuilder: HeaderBuilder

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_toolbar)
        setSupportActionBar(toolbar)
        setDefaultListener()
        initToolBarOperate()
    }


    private fun setDefaultListener() {
        left_iv!!.setOnClickListener(object : OnClickListener() {
            protected override fun clickOperate() {
                back()
            }
        })
    }

    fun initToolBarOperate() {
        mHeaderBuilder = HeaderBuilder()
        initTitleBar(mHeaderBuilder)
    }

    protected abstract fun initTitleBar(builder: HeaderBuilder)


    protected fun addContent(viewId: Int) {
        LayoutInflater.from(this).inflate(viewId, public_layout)
    }

    inner class HeaderBuilder {
        fun setTitle(resId: Int) {
            if (title_tv == null) {
                return
            }
            val title = ContextUtils.instance.getResources().getString(resId)
            title_tv!!.setText(title)
        }

        fun setTitle(title: String) {
            if (title_tv == null || TextUtils.isEmpty(title)) {
                return
            }
            title_tv!!.text = title
        }

        fun setLeftOperate(imgResId: Int, listener: OnClickListener) {
            left_iv!!.visibility = View.VISIBLE
            left_iv!!.setImageResource(imgResId)
            left_iv!!.setOnClickListener(listener)
        }

        fun setRightImgOperate(imgResId: Int, listener: OnClickListener) {
            right_iv!!.visibility = View.VISIBLE
            right_tv!!.visibility = View.GONE
            right_iv!!.setImageResource(imgResId)
            right_iv!!.setOnClickListener(listener)
        }

        fun setRightTvOperate(textResId: Int, listener: OnClickListener) {
            right_tv!!.visibility = View.VISIBLE
            right_iv!!.visibility = View.GONE
            val content = resources.getString(textResId)
            right_tv!!.text = content
            right_tv!!.setOnClickListener(listener)
        }

        fun setRightTvSize(textSize: Float) {
            right_tv!!.textSize = textSize
        }

        fun setRightTvText(textResId: Int) {
            val content = resources.getString(textResId)
            right_tv!!.text = content
        }

        fun setRightTvColor(colorResId: Int) {
            val colorId = resources.getColor(colorResId)
            right_tv!!.setTextColor(colorId)
        }

        fun setRightTvEnable(able: Boolean) {
            right_tv!!.isEnabled = able
        }

        fun goneLeft() {
            left_iv!!.visibility = View.GONE
        }

        fun goneToolbar() {
            toolbar!!.visibility = View.GONE
        }

        fun showToolbar() {
            toolbar!!.visibility = View.VISIBLE
        }

        fun goneRightTv() {
            right_tv!!.visibility = View.GONE
        }

        fun goneRightImg() {
            right_iv!!.visibility = View.GONE
        }
    }

    protected fun <VG : View> getViewById(resId: Int): VG {
        return public_layout!!.findViewById<View>(resId) as VG
    }

    fun back() {
        finish()
    }
}