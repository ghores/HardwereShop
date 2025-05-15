package com.example.hardwareshop.feature.home.repository

import com.example.hardwareshop.data.ResponseBanners
import com.example.hardwareshop.feature.home.source.BannerDataSource
import com.example.hardwareshop.feature.home.source.LocalBannersDataSource
import io.reactivex.Single

class BannerRepositoryImpl(
    val remoteBannersDataSource: BannerDataSource,
    val localBannersDataSource: LocalBannersDataSource
) : BannerRepository {
    override fun getBanner(): Single<List<ResponseBanners>> = remoteBannersDataSource.getBanner()
}