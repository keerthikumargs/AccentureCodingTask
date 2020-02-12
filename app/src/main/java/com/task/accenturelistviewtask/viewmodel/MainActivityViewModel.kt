package com.task.accenturelistviewtask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.task.accenturelistviewtask.network.model.CanadaDataModel
import com.task.accenturelistviewtask.repository.MainActivityRepository

class MainActivityViewModel(application:Application) : AndroidViewModel(application){

    private val repository = MainActivityRepository(application)
    val canadaData : LiveData<CanadaDataModel>

    init {
        this.canadaData = repository.canadaData
    }

    fun fetchCanadaData(){
        repository.fetchCanadaData()   // Call API from Repository
    }

}