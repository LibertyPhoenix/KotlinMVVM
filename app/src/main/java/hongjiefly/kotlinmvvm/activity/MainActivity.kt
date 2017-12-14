package hongjiefly.kotlinmvvm.activity

import android.os.Bundle
import hongjiefly.kotlinmvvm.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun getContentResId(): Int {
        return R.layout.activity_main
    }

    override fun initTitleBar(builder: HeaderBuilder) {
        builder.setTitle("首页")
    }
}
