package com.example.hardwareshop.utils

import android.app.Application
import com.example.hardwareshop.api.ApiService
import com.example.hardwareshop.api.retrofitApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val myModule = module {
            single<ApiService> { retrofitApi() }
        }
        startKoin {
            androidContext(this@App)
            modules(myModule)
        }
    }
}