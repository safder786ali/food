package com.example.foodeze.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.model.HomeHeadModel
import com.squareup.picasso.Picasso

class HomeSlipderAdapter (val context: Context, var sliderhead:ArrayList<HomeHeadModel>):
    RecyclerView.Adapter<HomeSlipderAdapter.SliderHeadViewModel>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderHeadViewModel {
        val attenre = LayoutInflater.from(context).inflate(R.layout.item_sliderhead,parent,false)
        return  SliderHeadViewModel(attenre)
    }

    override fun getItemCount(): Int {
        return if(sliderhead !=null) sliderhead.size else 0
    }

    override fun onBindViewHolder(holder: SliderHeadViewModel, position: Int) {
       // holder.SlImageName.setImageDrawable(R.drawable.adt_hint_background)
        Picasso.with(context)
            .load(sliderhead[position].headimg_url.toString())
            .noFade()
            .resize(5000,5000)
            .onlyScaleDown()
            .into(holder.SlImageName)


    }
    fun clear(){

        sliderhead.clear()
        notifyDataSetChanged()

    }



    class SliderHeadViewModel(slhead: View): RecyclerView.ViewHolder(slhead) {
        var SlImageName = slhead.findViewById<ImageView>(R.id.slidimag)




        fun binditem(annoutmodel: HomeHeadModel){

        }

    }

}
