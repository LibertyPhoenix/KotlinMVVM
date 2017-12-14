package hongjiefly.kotlinmvvm.activity

import android.content.Context

/**
 * 作用：获取上下文
 * author：王宏杰.
 * date：Created on 2017/2/24.
 */
object ContextUtils {
    private var sContext: Context? = null

    fun init(context: Context) {
        sContext = context
    }

    val instance: Context
        get() {
            if (sContext == null) {
                throw NullPointerException("the context is null,please init ContextUtils in Application first.")
            }
            return sContext as Context
        }
}