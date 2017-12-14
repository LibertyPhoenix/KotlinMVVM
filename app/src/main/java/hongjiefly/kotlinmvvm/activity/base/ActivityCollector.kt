package hongjiefly.kotlinmvvm.activity

import android.app.Activity
import java.util.*

/**
 * 作用：存储所有activity
 * author：王宏杰.
 * date：Created on 2017/2/8.
 */
object ActivityCollector {
    var activityList: MutableList<Activity> = ArrayList()

    //将Activity加入集合
    fun addActivity(activity: Activity) {
        activityList.add(activity)
    }

    //将Activity移除集合
    fun removeActivity(activity: Activity) {
        activityList.remove(activity)
    }

    //关闭所有Activity
    fun finishAll() {
        for (activity in activityList) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
    }

    //关闭除了自身以外的所有Activity
    fun finishAllWithoutMyself() {
        for (i in 0..activityList.size - 1 - 1) {
            if (!activityList[i].isFinishing) {
                activityList[i].finish()
            }
        }
    }
}