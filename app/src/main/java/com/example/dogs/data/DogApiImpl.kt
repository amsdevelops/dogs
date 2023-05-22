package com.example.dogs.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogApiImpl : DogApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val dogService = retrofit.create(DogService::class.java)

    override fun getDogFacts(quantity: Int): Observable<com.example.dogs.data.model.Result> =
        dogService.getDogFacts(quantity)
            .subscribeOn(Schedulers.io())
}