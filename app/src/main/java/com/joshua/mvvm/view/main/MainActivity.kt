package com.joshua.mvvm.view.main

import android.os.Bundle
import androidx.activity.viewModels
import com.joshua.mvvm.R
import com.joshua.mvvm.view.base.BaseActivity

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}