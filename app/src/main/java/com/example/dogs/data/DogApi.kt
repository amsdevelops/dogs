package com.example.dogs.data

import io.reactivex.rxjava3.core.Observable

interface DogApi {
    fun getDogFacts(quantity: Int): Observable<com.example.dogs.data.model.Result>
}