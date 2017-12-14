package hongjiefly.kotlinmvvm.activity

import android.view.View

/**
 * 点击监听
 * author: 王宏杰
 * date: Created on 17/2/24.
 */
abstract class OnClickListener : View.OnClickListener {
    private var lastestClickTime: Long = 0
    private var period: Long = 500

    constructor() {}

    constructor(millsecond: Long) {
        this.period = millsecond
    }

    override fun onClick(v: View) {
        val clickTime = System.currentTimeMillis()
        if (Math.abs(clickTime - lastestClickTime) < period) {
            lastestClickTime = clickTime
            return
        }
        lastestClickTime = clickTime
        clickOperate()
    }

    protected abstract fun clickOperate()
}
