package com.example.hardwareshop.utils

import android.app.Application
import com.example.hardwareshop.api.ApiService
import com.example.hardwareshop.api.retrofitApi
import com.example.hardwareshop.feature.home.HomeViewModel
import com.example.hardwareshop.feature.home.repository.BannerRepository
import com.example.hardwareshop.feature.home.repository.BannerRepositoryImpl
import com.example.hardwareshop.feature.home.source.LocalBannersDataSource
import com.example.hardwareshop.feature.home.source.RemoteBannersDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        //for timber debugger
        Timber.plant(Timber.DebugTree())

        val myModule = module {
            single<ApiService> { retrofitApi() }
            //Banners
            factory<BannerRepository> {
                BannerRepositoryImpl(
                    RemoteBannersDataSource(get()),
                    LocalBannersDataSource()
                )
            }
            viewModel { HomeViewModel(get()) }
        }
        startKoin {
            androidContext(this@App)
            modules(myModule)
        }
    }
}