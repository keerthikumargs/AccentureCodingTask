package com.task.accenturelistviewtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.task.accenturelistviewtask.R
import com.task.accenturelistviewtask.network.model.CanadaDataModel
import com.task.accenturelistviewtask.network.model.Row
import kotlinx.android.synthetic.main.canada_list_item.view.*

class CanadaDataAdapter(private val context : Context) :
    RecyclerView.Adapter<CanadaDataAdapter.ViewHolder>(){

    private var list : List<Row> = ArrayList()

    fun setCanadaDataList(list: List<Row>){
        this.list = list
        notifyDataSetChanged()                  //update the list with latest data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.canada_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size                        //return list size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.description.text = list[position].description
        Glide.with(context).asDrawable().load(list[position].imageHref).into(holder.image)   //load image using glide
    }


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val title = v.id_title!!
        val description = v.id_description!!
        val image = v.id_image!!
    }

}