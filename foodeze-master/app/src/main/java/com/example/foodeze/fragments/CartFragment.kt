package com.ff.deptmanager.fragment


import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.activity.LoadingDialog
import com.example.foodeze.adapter.CartAdatper
import com.example.foodeze.adapter.HomeAllProductsAdapter
import com.example.foodeze.adapter.HomeSlipderAdapter
import com.example.foodeze.model.CartModel
import com.example.foodeze.model.HomeHeadModel
import com.example.foodeze.model.HomeItemProductModel
import com.example.foodeze.room.CartDAO
import com.example.foodeze.room.CartDataBase
import com.example.foodeze.room.HirstoryDAO
import com.example.foodeze.room.HistoryProdut
import com.example.lanecrowd.util.Coroutines
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CartFragment : Fragment(), CartAdatper.SentTotal {
    override fun data(cd: Int) {
        println("cartFrag  "+cd)
        txtsubtotal.setText("$ "+cd)
        cart_txt_total.setText("$ "+cd)
        //getint = cd
    }

    private lateinit var cartrv: RecyclerView;
    var layoutLin : LinearLayoutManager?=null
    var cartlist:ArrayList<CartModel> = ArrayList<CartModel>()
   var histlist   = ArrayList<HistoryProdut>()
   // var histlist = ArrayList<HistoryProdut>()
    //var histmode = HistoryProdut();
    private var cartadapter : CartAdatper?=null
    lateinit var cartmodel: HomeHeadModel
    lateinit var views:View
    lateinit var cartget:CartDAO
    lateinit var histget:HirstoryDAO
    lateinit var txtsubtotal:TextView
    lateinit var cart_txt_total:TextView
    lateinit var Cart_bt_checkout:Button
    var getint:Int = 0
    lateinit var cartroot: ConstraintLayout
    lateinit var loading: LoadingDialog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        views = inflater.inflate(R.layout.fragment_cart, container, false)
        cartget = CartDataBase.getDatabase(views.context).cartDAO()
        histget = CartDataBase.getDatabase(views.context).historyDAO()
        cartroot = views.findViewById(R.id.cartroot)
        loading = LoadingDialog(views.context)
        cartrv = views.findViewById(R.id.cartrv)
        txtsubtotal = views.findViewById(R.id.cart_sub_total)
        cart_txt_total = views.findViewById(R.id.cart_txt_total)
        Cart_bt_checkout = views.findViewById(R.id.Cart_bt_checkout)
        CartItem()



        Cart_bt_checkout.setOnClickListener {
            println("fragbt "+cart_txt_total.text.toString());
            println("sdfsdfsdf")
             val alter:AlertDialog.Builder = AlertDialog.Builder(views.context)
            alter.setMessage("Do you Want Check Out")
                .setCancelable(false)
                .setPositiveButton("Yes")
                {dialogInterface, i ->

                    doAsync {

                        for(i in 0 until cartget.getAllUsers().size){


                            println("sdfsdf "  +cartget.getAllUsers().get(i).prod_id.toString())
                            histlist.add(HistoryProdut(cartget.getAllUsers().get(i).prod_id.toString(),
                                cartget.getAllUsers().get(i).prod_baner.toString(),
                                cartget.getAllUsers().get(i).prod_titel.toString(),
                                cartget.getAllUsers().get(i).prod_rest.toString(),
                                cartget.getAllUsers().get(i).prod_qunty.toString(),
                                cartget.getAllUsers().get(i).prod_total.toString()
                            ))
                        }
                        histget.HistoryMult(histlist)
                        println("sdfsdfsdf")
                        uiThread {

                        }
                    }
                    val snackbar = Snackbar
                        .make(cartroot, "Order Placed Successfully", Snackbar.LENGTH_LONG)
                    snackbar.show()
                }
            alter.setNegativeButton("No"){dialogInterface, which ->
                val snackbar = Snackbar
                    .make(cartroot, "Order are not Placed..", Snackbar.LENGTH_LONG)
                snackbar.show()
            }




            // var histdlist: List<HistoryProdut> = ArrayList<HistoryProdut>()

               /* histlist.add(HistoryProdut("1","sdf","sdf","sdf","sdf", "sdf"))
                histlist.add(HistoryProdut("1","sdf","sdf","sdf","sdf", "sdf"))
                histlist.add(HistoryProdut("1","sdf","sdf","sdf","sdf", "sdf"))*/


            val alertDialog: AlertDialog = alter.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
            val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
            with(button) {
                setBackgroundColor(Color.WHITE)
                setPadding(20, 20, 20, 20)

                setTextColor(Color.BLACK)

            }
            val button1 = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
            with(button1) {
                setBackgroundColor(Color.WHITE)
                setPadding(20, 20, 20, 20)

                setTextColor(Color.BLACK)
            }

        }
        return views
    }

    fun GetCartDataRoom(){

    }

    fun CartItem() {
        /*  cartlist.add(CartModel("sdfsdf"
            ,"https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
            ,"asdasd"
            ,"dfsdfsf",
            "20"))*/
        loading.startLoadingDialog()
        doAsync {
            for (i in 0 until cartget.getAllUsers().size) {
                cartlist.add(
                    CartModel(
                        cartget.getAllUsers().get(i).prod_id.toString()
                        , cartget.getAllUsers().get(i).prod_baner.toString()
                        , cartget.getAllUsers().get(i).prod_titel.toString()
                        , cartget.getAllUsers().get(i).prod_rest,
                        cartget.getAllUsers().get(i).prod_total
                    )
                )

                uiThread {
                    layoutLin = LinearLayoutManager(views.context)
                    layoutLin!!.orientation = LinearLayoutManager.VERTICAL
                    cartrv!!.setHasFixedSize(true)
                    cartrv.scrollState
                    cartrv!!.layoutManager = layoutLin
                    cartadapter = CartAdatper(views.context, cartlist, this@CartFragment)
                    cartrv!!.adapter = cartadapter
                    cartadapter!!.notifyDataSetChanged()
                }
                loading.dismissDialog()
            }
            /* Thread{


                println("sdfsdf "  +cartget.getAllUsers().get(i).prod_id.toString())

            }


        }.start()*/


            // println("sdfsdf"   +cartget.getAllUsers().size)
            /* cartlist.add(CartModel("sdfsdf"
                ,"https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
                ,"asdasd"
                ,"dfsdfsf",
                "20"))*/
            /*for(i in 0 until cartget.getAllUsers().size){
                *//*cartlist.add(CartModel(cartget.getAllUsers().get(i).prod_id.toString()
                    ,cartget.getAllUsers().get(i).prod_baner.toString()
                    ,cartget.getAllUsers().get(i).prod_titel.toString()
                    ,cartget.getAllUsers().get(i).prod_rest,
                     cartget.getAllUsers().get(i).prod_total))*//*


                //println("sdfsdf "  +cartget.getAllUsers().get(i).prod_id.toString())

            }*/
            // cartlist.add(CartModel(cartget.getAllUsers().get(0).prod_id.toString(),cartget.getAllUsers().get(0).prod_titel.toString()))


            //cartlist.add(CartModel(cartget.getAllUsers().get(0).prod_id!!,"https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
            /*cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        cartlist.add(CartModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))*/


        }

    }
}
