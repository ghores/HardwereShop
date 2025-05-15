package com.example.hardwareshop.feature.home.source

import com.example.hardwareshop.data.ResponseBanners
import io.reactivex.Single

interface BannerDataSource {
    fun getBanner(): Single<List<ResponseBanners>>
}