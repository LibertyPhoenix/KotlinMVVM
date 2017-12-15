package hongjiefly.kotlinmvvm.activity

import android.content.Context
import android.content.Intent


/**
 * 作用：跳转类工具
 * author: 王宏杰
 * date: Created on 2017/12/12.
 */
object LaunchOperate {

    /**
     * 跳转 测试页 （功能列表页）

     * @param context
     */
    fun openTestActivity(context: Context) {
        val intent = Intent(context, TestActivity::class.java)
        context.startActivity(intent)
    }
}