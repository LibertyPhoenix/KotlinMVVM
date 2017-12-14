package hongjiefly.kotlinmvvm.activity

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.umeng.analytics.MobclickAgent

/**
 * 作用：友盟统计Activity
 * author：王宏杰.
 * date：Created on 2017/12/12.
 */
open class UmengActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        MobclickAgent.onPageStart(TAG)
        MobclickAgent.onResume(this)
        /*if (!isAppOnForeground()) {
            CpsModel.cpsSimple("app进入前台", "", "", System.currentTimeMillis() / 1000 + "");
        }*/
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPageEnd(TAG)
        MobclickAgent.onPause(this)
    }

    override fun onStop() {
        super.onStop()
        /*if (!isAppOnForeground()) {
            CpsModel.cpsSimple("app进入后台", "", "", ((System.currentTimeMillis() - MainActivity.OPEN_TIME) / 1000) + "");
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    /**
     * 程序是否在前台运行
     */
    val isAppOnForeground: Boolean
        get() {
            val activityManager = applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            val packageName = applicationContext.packageName

            val appProcesses = activityManager
                    .runningAppProcesses ?: return false

            for (appProcess in appProcesses) {
                if (appProcess.processName == packageName && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    return true
                }
            }
            return false
        }
}
