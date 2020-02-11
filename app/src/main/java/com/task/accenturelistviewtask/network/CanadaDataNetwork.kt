package com.task.accenturelistviewtask.network

import com.task.accenturelistviewtask.network.model.CanadaDataModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/"

interface CanadaDataNetwork {

    @GET("facts.json")
    fun getCanadaData(): Call<CanadaDataModel>

}