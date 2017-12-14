package hongjiefly.kotlinmvvm.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.KeyEvent
import android.widget.Toast
import hongjiefly.kotlinmvvm.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : BaseActivity() {

     var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHeaderBuilder.goneToolbar()
        initViewPager()
    }


    fun initViewPager() {

        val title = ArrayList<String>()
        title.add("")
        title.add("")
        title.add("")
        title.add("")
        val pageAdapter = object : TabFragmentPageAdapter(supportFragmentManager, title) {
            override fun geFragment(position: Int): Fragment? {
                when (position) {
                    0 -> return HomeFragment.newInstance()
                    1 -> return HomeFragment.newInstance()
                    2 -> return HomeFragment.newInstance()
                    3 -> return HomeFragment.newInstance()
                }
                return null
            }
        }
        activity_main_vp!!.setAdapter(pageAdapter)

    }


    override fun getContentResId(): Int {
        return R.layout.activity_main
    }

    override fun setListener() {

        activity_main_vp.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> tab_rb_1.setChecked(true)
                    1 -> tab_rb_2.setChecked(true)
                    2 -> tab_rb_3.setChecked(true)
                    3 -> tab_rb_4.setChecked(true)
                }
            }
        })
        tab_rg_menu!!.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.tab_rb_1 -> activity_main_vp!!.currentItem = 0
                R.id.tab_rb_2 -> activity_main_vp!!.currentItem = 1
                R.id.tab_rb_3 -> activity_main_vp!!.currentItem = 2
                R.id.tab_rb_4 -> activity_main_vp!!.currentItem = 3
                else -> {
                }
            }
        }
    }

    //  点击两次退出App
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            count++
            if (count == 1) {
                Toast.makeText(this, "再点一次返回键退出App", Toast.LENGTH_SHORT).show()
            }
            val timer = Timer()
            timer.schedule(
                    object : TimerTask() {
                        override fun run() {
                            count = 0
                        }
                    }, 2000
            )

            if (count == 2) {
                finish()
            }
        }
        return false
    }

}