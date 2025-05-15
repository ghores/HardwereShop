package com.example.hardwareshop.feature.home.source

import com.example.hardwareshop.data.ResponseBanners
import io.reactivex.Single

class LocalBannersDataSource :BannerDataSource{
    override fun getBanner(): Single<List<ResponseBanners>> {
        TODO("Not yet implemented")
    }
}