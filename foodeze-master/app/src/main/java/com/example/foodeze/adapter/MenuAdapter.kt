package com.example.foodeze.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.model.HomeProductModel
import com.example.foodeze.model.MenuModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MenuAdapter (val context: Context, var menuitem:ArrayList<MenuModel>):
    RecyclerView.Adapter<MenuAdapter.MenuViewModel>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewModel {
        val attenre = LayoutInflater.from(context).inflate(R.layout.item_menulist,parent,false)
        return  MenuViewModel(attenre)
    }

    override fun getItemCount(): Int {
        return if(menuitem !=null) menuitem.size else 0
    }

    override fun onBindViewHolder(holder: MenuViewModel, position: Int) {
        // holder.SlImageName.setImageDrawable(R.drawable.adt_hint_background)
        /*Picasso.with(context)
            .load(menuitem[position].menu_name)
            .noFade()
            .resize(5000,5000)
            .onlyScaleDown()
            .into(holder.homeproimg)
        holder.homeproname.setText(menuitem[position].menu_id)*/


    }
    fun clear(){

        //homeproduct.clear()
        notifyDataSetChanged()

    }



    class MenuViewModel(slhead: View): RecyclerView.ViewHolder(slhead) {
        var homeproimg = slhead.findViewById<CircleImageView>(R.id.imageview_item)
        var homeproname = slhead.findViewById<TextView>(R.id.txt_clinicname)







    }

}