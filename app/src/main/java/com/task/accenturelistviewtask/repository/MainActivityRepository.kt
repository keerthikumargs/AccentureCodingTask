package com.task.accenturelistviewtask.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.task.accenturelistviewtask.network.BASE_URL
import com.task.accenturelistviewtask.network.CanadaDataNetwork
import com.task.accenturelistviewtask.network.model.CanadaDataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivityRepository(val application: Application) {     // application for context reference

    val canadaData = MutableLiveData<CanadaDataModel>()

    fun fetchCanadaData(){

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(CanadaDataNetwork::class.java)

        service.getCanadaData().enqueue(object : Callback<CanadaDataModel>{

            override fun onFailure(call: Call<CanadaDataModel>, t: Throwable) {
                // log error
            }

            override fun onResponse(call: Call<CanadaDataModel>, response: Response<CanadaDataModel>) {
                canadaData.value = response.body()
            }
        })
    }


}