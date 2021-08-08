package com.example.appbusquedaml.manager

import com.example.appbusquedaml.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
        @GET
        fun getItemsBySearch(@Url url:String): Call<Response>
}