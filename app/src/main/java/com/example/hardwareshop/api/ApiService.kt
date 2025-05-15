package com.example.hardwareshop.api

import com.example.hardwareshop.data.ResponseBanners
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    //Home
    @GET("home/banners.php")
    fun getBanners(): Single<List<ResponseBanners>>
}

fun retrofitApi(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://tikdevelopers.com/mvvm/android/api/v1/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(ApiService::class.java)
}