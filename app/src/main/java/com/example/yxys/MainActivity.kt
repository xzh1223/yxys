package com.example.yxys

import com.example.yxys.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(){

    private var canvasView: CanvasView? = null

    override fun layout() = R.layout.activity_main

    override fun initData() {
    }

    override fun initUI() {
        canvasView = CanvasView(this)
        rl_background.addView(canvasView)
    }

    override fun event() {
        btn_change.setOnClickListener {
            canvasView!!.changeBackground(2,R.mipmap.icon_bg_1)
        }
    }
}
