package com.task.accenturelistviewtask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.accenturelistviewtask.R
import com.task.accenturelistviewtask.adapter.CanadaDataAdapter
import com.task.accenturelistviewtask.network.model.Row
import com.task.accenturelistviewtask.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainActivityViewModel
    private lateinit var adapter : CanadaDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        id_swipeRefresh.setOnRefreshListener {
            fetchData()                            // Update list by calling API
        }

        viewModel.canadaData.observe(this, Observer {
            supportActionBar?.title = it.title      /** default parameter CanadaDataModel referred as it */
            adapter.setCanadaDataList(it.rows)
            id_swipeRefresh.isRefreshing = false   //hide progress bar after updating the data
        })

        initialiseAdapter()

    }

    fun init(){

        supportActionBar?.title = ""             // Set actionbar title before API call
        id_swipeRefresh.isRefreshing = true     // Show swiperefresh layout progress bar

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)   //ViewModel reference

        id_recyclerView.layoutManager = LinearLayoutManager(this)        // Set LayoutManager for RecyclerView

        fetchData()
    }

    fun fetchData(){
        viewModel.fetchCanadaData()
    }

    fun initialiseAdapter(){
        adapter = CanadaDataAdapter(this)
        id_recyclerView.adapter = adapter
    }

}
