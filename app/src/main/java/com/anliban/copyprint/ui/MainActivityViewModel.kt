package com.anliban.copyprint.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anliban.copyprint.base.BaseViewModel
import com.anliban.copyprint.domain.MainUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    useCase: MainUseCase
) : BaseViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String>
        get() = _text

    init {
        _text.value = "hello"

        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}