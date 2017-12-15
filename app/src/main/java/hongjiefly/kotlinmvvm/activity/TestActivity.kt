package hongjiefly.kotlinmvvm.activity

import android.os.Bundle
import hongjiefly.kotlinmvvm.R

class TestActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getContentResId(): Int {
        return R.layout.activity_test
    }

    override fun initTitleBar(builder: ToolBarActivity.HeaderBuilder) {
        builder.setTitle("功能列表")
    }
}
