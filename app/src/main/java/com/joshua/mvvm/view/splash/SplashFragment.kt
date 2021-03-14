package com.joshua.mvvm.view.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.joshua.mvvm.R
import com.joshua.mvvm.view.base.BaseFragment

class SplashFragment : BaseFragment() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_splash
    }
}