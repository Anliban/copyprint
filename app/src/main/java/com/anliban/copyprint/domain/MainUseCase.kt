package com.anliban.copyprint.domain

import com.anliban.copyprint.model.Copy

class MainUseCase constructor(
    private val repository: MainRepository
) {

    suspend fun copyList(): List<Copy> {
        return repository.copyList()
    }
}