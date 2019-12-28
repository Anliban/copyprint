package com.anliban.copyprint.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anliban.copyprint.base.BaseViewModel
import com.anliban.copyprint.domain.MainUseCase
import com.anliban.copyprint.model.Copy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    useCase: MainUseCase
) : BaseViewModel(), MainEventListener {

    private val _copyList = MutableLiveData<List<Copy>>()
    val copyList: LiveData<List<Copy>>
        get() = _copyList

    init {

        viewModelScope.launch(Dispatchers.IO) {

            val items = useCase.copyList()

            launch(Dispatchers.Main) {
                _copyList.value = items
            }
        }
    }

    override fun onClick(copy: Copy) {

    }
}

interface MainEventListener {

    fun onClick(copy: Copy)
}