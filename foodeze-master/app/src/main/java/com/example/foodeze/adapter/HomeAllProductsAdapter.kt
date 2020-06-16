package com.example.foodeze.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.model.HomeHeadModel
import com.example.foodeze.model.HomeProductModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class HomeAllProductsAdapter(val context: Context, var homeproduct:ArrayList<HomeProductModel>):
    RecyclerView.Adapter<HomeAllProductsAdapter.HomeProductViewModel>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductViewModel {
        val attenre = LayoutInflater.from(context).inflate(R.layout.item_homeallproduct,parent,false)
        return  HomeProductViewModel(attenre)
    }

    override fun getItemCount(): Int {
        return if(homeproduct !=null) homeproduct.size else 0
    }

    override fun onBindViewHolder(holder: HomeProductViewModel, position: Int) {
        // holder.SlImageName.setImageDrawable(R.drawable.adt_hint_background)

        Picasso.with(context)
            .load(homeproduct[position].homepro_url)
            /*.noFade()
            .resize(5000,5000)
            .onlyScaleDown()*/
            .into(holder.homeproimg)
        holder.homeproname.setText(homeproduct[position].homepro_name)


    }
    fun clear(){

        homeproduct.clear()
        notifyDataSetChanged()

    }



    class HomeProductViewModel(slhead: View): RecyclerView.ViewHolder(slhead) {
        var homeproimg = slhead.findViewById<ImageView>(R.id.imageview_item)
        var homeproname = slhead.findViewById<TextView>(R.id.txt_clinicname)







    }

}
