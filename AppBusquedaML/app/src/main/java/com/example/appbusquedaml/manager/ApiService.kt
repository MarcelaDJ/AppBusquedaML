package com.example.appbusquedaml.manager

import com.example.appbusquedaml.model.Response
import com.example.appbusquedaml.tools.Constants
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
  //  @GET(Constants.SITE_ID+"/search")
    @GET("search")
    fun getItemsBySearch(@Query("q") search: String?): Call<Response>
}