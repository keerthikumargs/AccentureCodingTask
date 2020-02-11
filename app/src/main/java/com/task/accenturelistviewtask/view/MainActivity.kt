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

        supportActionBar?.title = ""

        id_swipeRefresh.isRefreshing = true
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        id_recyclerView.layoutManager = LinearLayoutManager(this)
        id_swipeRefresh.setOnRefreshListener {
            viewModel.fetchCanadaData()
            id_swipeRefresh.isRefreshing = false
        }

        /*viewModel.showProgress.observe(this, Observer {

        })*/

        viewModel.canadaData.observe(this, Observer {
            supportActionBar?.title = it.title
            adapter.setCanadaDataList(it.rows)
            id_swipeRefresh.isRefreshing = false
        })

        viewModel.fetchCanadaData()
        adapter = CanadaDataAdapter(this)
        id_recyclerView.adapter = adapter


    }

}
