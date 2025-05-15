package com.example.hardwareshop.feature.home.repository

import com.example.hardwareshop.data.ResponseBanners
import io.reactivex.Single

interface BannerRepository {
    fun getBanner(): Single<List<ResponseBanners>>
}