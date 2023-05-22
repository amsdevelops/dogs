package com.example.dogs.data

import com.example.dogs.domain.model.Dog
import io.reactivex.rxjava3.core.Observable

class DogsRepositoryImpl(private val dogFactsApi: DogApi) : DogsRepository {

    override fun getDogFacts(quantity: Int): Observable<Dog> = dogFactsApi.getDogFacts(quantity).map {
        Dog(it.message)
    }
}