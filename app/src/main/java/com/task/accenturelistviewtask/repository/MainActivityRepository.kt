package com.task.accenturelistviewtask.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.task.accenturelistviewtask.network.*
import com.task.accenturelistviewtask.network.model.CanadaDataModel
import com.task.accenturelistviewtask.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivityRepository(val application: Application) {     // application for context reference

    val canadaData = MutableLiveData<CanadaDataModel>()
    val progressBar = MutableLiveData<Boolean>()

    fun fetchCanadaData(){

        val retrofit = RetrofitAPIClient.getRetrofitClient(application)

        val service = retrofit?.create(CanadaDataNetwork::class.java)

        service?.getCanadaData()?.enqueue(object : Callback<CanadaDataModel>{

            override fun onFailure(call: Call<CanadaDataModel>, t: Throwable) {
                // log error
                if(t is NoConnectivityException){
                    progressBar.value = true
                    val toast = Toast.makeText(application, "No Internet Connection", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }

            override fun onResponse(call: Call<CanadaDataModel>, response: Response<CanadaDataModel>) {
                canadaData.value = response.body()
            }
        })
    }


}