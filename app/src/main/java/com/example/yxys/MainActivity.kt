package com.example.yxys

import com.example.yxys.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){

    override fun layout() = R.layout.activity_main

    override fun initData() {
    }

    override fun initUI() {
        val canvasView = CanvasView(this)
        rl_background.addView(canvasView)
    }

    override fun event() {
    }
}
