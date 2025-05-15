package com.example.hardwareshop.feature.home

import androidx.lifecycle.MutableLiveData
import com.example.hardwareshop.base.BaseViewModel
import com.example.hardwareshop.data.ResponseBanners
import com.example.hardwareshop.feature.home.repository.BannerRepository
import com.example.hardwareshop.utils.DigiShopSingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(val bannerRepository: BannerRepository) : BaseViewModel() {
    var bannersLiveData = MutableLiveData<List<ResponseBanners>>()

    init {
        progressBarLiveData.value = true
        bannerRepository.getBanner().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                progressBarLiveData.value = false
            }
            .subscribe(object : DigiShopSingleObserver<List<ResponseBanners>>(compositeDisposable) {
                override fun onSuccess(t: List<ResponseBanners>) {
                    bannersLiveData.value = t
                }
            })
    }
}