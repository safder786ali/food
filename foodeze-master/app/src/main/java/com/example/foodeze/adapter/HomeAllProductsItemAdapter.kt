package com.example.foodeze.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.model.HomeItemProductModel
import com.ff.deptmanager.fragment.OderFragment
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

import com.example.foodeze.activity.HomeActivity
import com.example.foodeze.activity.OrderAcitivity


class HomeAllProductsItemAdapter(val context: Context, var homeitemproduct:ArrayList<HomeItemProductModel>,var homeallprod:HomeAllProd):
    RecyclerView.Adapter<HomeAllProductsItemAdapter.HomeProductItemViewModel>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductItemViewModel {
        val attenre = LayoutInflater.from(context).inflate(R.layout.item_productitem,parent,false)
        return  HomeProductItemViewModel(attenre)
    }

    override fun getItemCount(): Int {
        return if(homeitemproduct !=null) homeitemproduct.size else 0
    }

    override fun onBindViewHolder(holder: HomeProductItemViewModel, position: Int) {
        // holder.SlImageName.setImageDrawable(R.drawable.adt_hint_background)
         val bestseller = homeitemproduct[position].best_seller
        if(bestseller.equals("1")){
            holder.homepro_txt_seller.setText("Best Seller")

        }else if(bestseller.equals("0")){
            holder.homepro_txt_seller.setText("Good Seller")
        }
        val prolike = homeitemproduct[position].likes
        if(prolike.equals("1")){
            Picasso.with(context)
                .load(R.drawable.favlike)
                .noFade()
                .resize(5000,5000)
                .onlyScaleDown()
                .into(holder.homepro_img_like)
        } else if(prolike.equals("0")) {
            Picasso.with(context)
                .load(R.drawable.fav_icon)
                .noFade()
                .resize(5000,5000)
                .onlyScaleDown()
                .into(holder.homepro_img_like)

        }
         //holder.homepro_txt_seller.setText(homeitemproduct[position].best_seller)
         //holder.homepro_txt_seller.setText(homeitemproduct[position].best_seller)
         holder.homepro_txt_protitel.setText(homeitemproduct[position].product_title)
         holder.homepro_txt_restname.setText(homeitemproduct[position].restaurent_name)
         holder.homepro_txt_price.setText("$ "+homeitemproduct[position].product_price)
         holder.homepro_txt_price.setText("$ "+homeitemproduct[position].product_price)
         holder.homepro_txt_discond.setText(homeitemproduct[position].product_discount+" %")
         holder.homepro_bt_add.setOnClickListener {
             val snackbar = Snackbar
                 .make(holder.homepro_lay, "www.journaldev.com", Snackbar.LENGTH_LONG)
             snackbar.show()
         }
        Picasso.with(context)
            .load(homeitemproduct[position].image)
            .noFade()
            .resize(5000,5000)
            .onlyScaleDown()
            .into(holder.homepro_img_ban)
        var ab:String = "1"
        var ac:String = "0"
        holder.homepro_img_like.setOnClickListener {


            println("test "+homeitemproduct[position].likes)

            if(ab == "1") {
                homeallprod.HomeProdlike(homeitemproduct[position].id.toString(),"1")
                println("A")
                ab = "0"
                Picasso.with(context)
                    .load(R.drawable.fav_icon)
                    .noFade()
                    .resize(5000,5000)
                    .onlyScaleDown()
                    .into(holder.homepro_img_like)
            }
            else{
                homeallprod.HomeProdlike(homeitemproduct[position].id.toString(),"0")
                println("B")
                ab = "1"
                Picasso.with(context)

                    .load(R.drawable.favlike)
                    .noFade()
                    .resize(5000,5000)
                    .onlyScaleDown()
                    .into(holder.homepro_img_like)
            }

        }

       holder.homepro_bt_add.setOnClickListener {


           context.startActivity(Intent(context.applicationContext,OrderAcitivity::class.java).putExtra("Prod_id",homeitemproduct[position].id.toString()))
           /*val ldfweb = OderFragment()
           val args = Bundle()
           args.putString("User_id","1")
           args.putString("Prod_id",homeitemproduct[position].id.toString())



           ldfweb.setArguments(args)
           val fm = (context as HomeActivity).supportFragmentManager
           // create a FragmentTransaction to begin the transaction and replace the Fragment
           val fragmentTransaction = fm.beginTransaction()
           // replace the FrameLayout with new Fragment
           fragmentTransaction.replace(R.id.fragment_container, ldfweb)
           fragmentTransaction.commit()*/

           }

    }
    fun clear(){

        homeitemproduct.clear()
        notifyDataSetChanged()

    }



    class HomeProductItemViewModel(slhead: View): RecyclerView.ViewHolder(slhead) {
        var homepro_img_like = slhead.findViewById<ImageView>(R.id.homepro_img_like)
        var homepro_img_ban = slhead.findViewById<ImageView>(R.id.homepro_img_ban)
        var homepro_lay = slhead.findViewById<RelativeLayout>(R.id.homepro_lay)
        var homepro_txt_seller = slhead.findViewById<TextView>(R.id.homepro_txt_seller)
        var homepro_txt_protitel = slhead.findViewById<TextView>(R.id.homepro_txt_protitel)
        var homepro_txt_restname = slhead.findViewById<TextView>(R.id.homepro_txt_restname)
        var homepro_txt_price = slhead.findViewById<TextView>(R.id.homepro_txt_price)
        var homepro_txt_discond = slhead.findViewById<TextView>(R.id.homepro_txt_discond)
        var homepro_bt_add = slhead.findViewById<Button>(R.id.homepro_bt_add)
        //var homeproname = slhead.findViewById<TextView>(R.id.txt_clinicname)

    }

    interface  HomeAllProd{
        fun HomeProdlike(pro_id:String,pro_like_unlike:String)
    }

}
