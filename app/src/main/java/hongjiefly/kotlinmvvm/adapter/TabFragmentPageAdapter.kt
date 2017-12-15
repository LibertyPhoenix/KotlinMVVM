package hongjiefly.kotlinmvvm.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup

/**
 * 基类 Tab切换
 */
abstract class TabFragmentPageAdapter : FragmentPagerAdapter {
    var titleList: List<String>? =null

    var currentFragment: Fragment? = null

    constructor(fm: FragmentManager) : super(fm) {}

    constructor(fm: FragmentManager, titles: List<String>) : super(fm) {
        titleList = titles
    }

    override fun getItem(position: Int): Fragment? {
        val fragment = geFragment(position)
        return fragment
    }

    override fun getCount(): Int {
        return titleList!!.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        if (titleList == null || titleList!!.size == 0) {
            return ""
        }
        return titleList!![position]
    }

    override fun setPrimaryItem(container: ViewGroup?, position: Int, `object`: Any) {
        currentFragment = `object` as Fragment
        super.setPrimaryItem(container, position, `object`)
    }

    protected abstract fun geFragment(position: Int): Fragment?

}
