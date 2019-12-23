package com.anliban.copyprint.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anliban.copyprint.base.BaseViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(

) : BaseViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String>
        get() = _text

    init {
        _text.value = "hello"
    }
}