package com.joshua.mvvm

import android.app.Application
import com.joshua.mvvm.di.apiModule
import com.joshua.mvvm.di.appModule
import com.joshua.mvvm.di.repositoryModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var self: Application
        fun applicationContext(): Application {
            return self
        }
    }

    init {
        self = this
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }

        val module = listOf(
            appModule,
            apiModule,
            repositoryModule
        )

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(module)
        }
    }
}