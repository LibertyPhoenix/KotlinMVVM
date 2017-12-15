package hongjiefly.kotlinmvvm.activity

import android.view.View
import hongjiefly.kotlinmvvm.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 模块：首页
 * author: 王宏杰
 * date: Created on 2017/12/12.
 */
class HomeFragment : BaseFragment() {


    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }


    override fun getContentResId(): Int {
        return R.layout.fragment_home
    }

    override fun setListener() {
        test_tv.setOnClickListener(View.OnClickListener { LaunchOperate.openTestActivity(activity) })
//        test_tv.setOnClickListener(View.OnClickListener { Toast.makeText(context,"jja",Toast.LENGTH_SHORT) })
    }



}