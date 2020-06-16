package com.example.foodeze.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.model.CartModel
import com.example.foodeze.model.OrderModel
import com.example.foodeze.room.CartDAO
import com.example.foodeze.room.CartDataBase
import com.example.foodeze.room.TestProdut
import com.squareup.picasso.Picasso

class OrderAdatper(val context: Context, var cartlist:ArrayList<OrderModel>):
    RecyclerView.Adapter<OrderAdatper.CartViewModel>(){
    lateinit var cartdO: CartDAO
    var prodcartr = TestProdut()
    lateinit var attenre: View
    var ab:Int =0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewModel {
        //attenre = LayoutInflater.from(context).inflate(R.layout.item_checkout,parent,false)

        attenre = LayoutInflater.from(context).inflate(R.layout.item_orderitem,parent,false)
        if (cartlist.isEmpty()){

        }

        return  CartViewModel(attenre)
    }

    override fun getItemCount(): Int {
        return if(cartlist !=null) cartlist.size else 0
    }

    override fun onBindViewHolder(holder: CartViewModel, position: Int) {

        holder.order_txt_title.setText(cartlist[position].Order_prod_title)
        holder.order_txt_rest.setText(cartlist[position].Order_prod_rest)
        holder.order_txt_total.setText(cartlist[position].Order_prod_total)
        // holder.SlImageName.setImageDrawable(R.drawable.adt_hint_background)
       // ab += cartlist[position].Cart_prod_total!!.toInt()
        //sentdata.data(ab)
        println("chelc "+ab)
        println( "checksize "+cartlist.size)
        Picasso.with(context)
            .load(cartlist[position].Order_prod_bang)
            .noFade()
            .resize(50,50)
            .onlyScaleDown()
            .into(holder.oder_img_image)
        // holder.homeproname.setText(homeproduct[position].homepro_name)
       /* holder.Cart_txt_remove.setOnClickListener {
            ab = cartlist[position].Cart_prod_total!!.toInt()
            Thread{
                cartdO = CartDataBase.getDatabase(context).cartDAO()
                // println("prod "+cartdO.getAllUsers().get(position).id)
                //prodcartr.prod_id = cartlist[position].Cart_prod_id
                prodcartr.id  = cartdO.getAllUsers().get(position).id
                cartdO.DeleteProd(prodcartr)
                println("Check Delete")
            }.start()
            ab -= cartlist[position].Cart_prod_total!!.toInt()
            sentdata.data(ab)
            cartlist.removeAt(position)
            notifyDataSetChanged()
        }*/
    }

    /*fun clear(){

        cartlist.clear()
        notifyDataSetChanged()

    }*/

    interface  SentTotal{
        fun data(cd:Int)
    }

    class CartViewModel(slhead: View): RecyclerView.ViewHolder(slhead) {
        var oder_img_image = slhead.findViewById<ImageView>(R.id.oder_img_image)
        var order_txt_title = slhead.findViewById<TextView>(R.id.order_txt_title)
        var order_txt_rest = slhead.findViewById<TextView>(R.id.order_txt_rest)
        var order_txt_total = slhead.findViewById<TextView>(R.id.order_txt_total)
        var Cart_txt_remove = slhead.findViewById<TextView>(R.id.Cart_txt_remove)

    }

}