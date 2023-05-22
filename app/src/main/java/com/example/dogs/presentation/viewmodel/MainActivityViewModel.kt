package com.example.dogs.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dogs.data.DogApiImpl
import com.example.dogs.data.DogsRepositoryImpl
import com.example.dogs.domain.model.Dog
import io.reactivex.rxjava3.core.Observable

class MainActivityViewModel : ViewModel() {

    private val repositoryImpl = DogsRepositoryImpl(DogApiImpl())

    fun getDogFacts(quantity: Int = 10): Observable<Dog> = repositoryImpl.getDogFacts(quantity)
}