package com.example.appbusquedaml.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appbusquedaml.model.Response

class GalleryViewModel : ViewModel() {

    private val _itemsFounds = MutableLiveData<Response>().apply {

    }
    val itemsFounds: LiveData<Response>
    get() = _itemsFounds
}