package com.example.hardwareshop.feature.home.source

import com.example.hardwareshop.api.ApiService
import com.example.hardwareshop.data.ResponseBanners
import io.reactivex.Single

class RemoteBannersDataSource(val apiService: ApiService) : BannerDataSource {
    override fun getBanner(): Single<List<ResponseBanners>> = apiService.getBanners()
}