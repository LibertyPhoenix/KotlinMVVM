package hongjiefly.kotlinmvvm.activity

import hongjiefly.kotlinmvvm.R

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

}