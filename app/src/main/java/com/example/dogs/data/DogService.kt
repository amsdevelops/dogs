package com.example.dogs.data

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface DogService {
    @GET("random")
    fun getDogFacts(@Query("number") quantity : Int): Observable<com.example.dogs.data.model.Result>
}