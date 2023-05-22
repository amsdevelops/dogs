package com.example.dogs.data

import com.example.dogs.domain.model.Dog
import io.reactivex.rxjava3.core.Observable

interface DogsRepository {
    fun getDogFacts(quantity: Int): Observable<Dog>
}