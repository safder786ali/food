package com.example.foodeze.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.foodeze.R
import com.example.foodeze.retrofit.GetLastIdCallback
import com.example.foodeze.room.*


import com.example.foodeze.util.ReadMoreOption
import com.example.foodeze.viewmodal.factory.HomeRestruVM
import com.example.foodeze.viewmodal.factory.OrderVM
import com.google.android.material.snackbar.Snackbar
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import com.steelkiwi.library.view.BadgeHolderLayout
import kotlinx.android.synthetic.main.fragment_restrau.*
import org.jetbrains.anko.doAsync

import org.json.JSONObject

class OrderAcitivity : AppCompatActivity() {
    var contadd:Int = 1
   

    var prod_id:String?=""
    var prod_price:String?=""
    var order_img_banc:ImageView?=null
    var order_txt_prodtitle:TextView?=null
    var order_txt_prodrest:TextView?=null
    var order_txt_price:TextView?=null
    var order_txt_start:TextView?=null
    var order_ratimg_start:RatingBar?=null
    var order_txt_readmore:TextView?=null
    var order_txt_quanty:TextView?=null
    var order_txt_plus:TextView?=null
    var order_txt_subra:TextView?=null
    var order_txt_totalprice:TextView?=null
    var order_bt_plaace:Button?=null
    var order_bt_addcard:Button?=null
    lateinit var ordervm:OrderVM
    lateinit var readmore: ReadMoreOption
    var prodcart: ProdCart?=null
    var prod_ban:String?=null
    var prod_total:String?=null
     lateinit var cartdO: CartDAO
    lateinit var loading: LoadingDialog
    lateinit var oder_lay: ConstraintLayout

   // var or:OrderAcitivity = OrderAcitivity();
     var badgeHolderLayout: BadgeHolderLayout?=null
    lateinit var homeRestuvm: HomeRestruVM
    var order_imgbt_likeuplike:ImageButton?=null
    var likeunlike:String?=""

    var abc:String ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_acitivity)
        homeRestuvm = ViewModelProvider(this).get(HomeRestruVM::class.java)
        prod_id = intent.getStringExtra("Prod_id")
        loading = LoadingDialog(this)
        oder_lay = findViewById(R.id.order_lay)
        cartdO = CartDataBase.getDatabase(this).cartDAO()
       // or.callback
        order_imgbt_likeuplike = findViewById(R.id.order_imgbt_likeuplike)
        badgeHolderLayout = findViewById(R.id.badgetholder)
        var prodcartr = TestProdut()
        ordervm = ViewModelProvider(this).get(OrderVM::class.java)
        inti()
        println("Check "+prod_id);
       OrderDetails("3",prod_id.toString())
       // ab = likeunlike.toString()
        doAsync {
            badgeHolderLayout!!.count = cartdO.getAllUsers().size
        }
        badgeHolderLayout!!.setOnClickListener {
            val intent : Intent = Intent(this,HomeActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.putExtra("cart_id","fgg")
            startActivity(intent)



        }

        order_txt_plus!!.setOnClickListener {
            contadd++
            order_txt_quanty!!.setText(contadd.toString())
            var total = prod_price!!.toInt()*contadd
            println("sdfsdf "+total.toString())
            order_txt_totalprice!!.setText("$ "+total.toString())
            prod_total = total.toString()

        }
        order_txt_subra!!.setOnClickListener {
            contadd--
            if (contadd > 0) {
                order_txt_quanty!!.setText(contadd.toString())
                var total = prod_price!!.toInt()*contadd
                println("sdfsdf "+total.toString())
                order_txt_totalprice!!.setText("$ "+total.toString())
                System.out.println("x is positive");
                prod_total = total.toString()

            } else if (contadd < 0) {
                System.out.println("x is negative");
                contadd =0
            } else {
                contadd =0
                System.out.println("x is zero");
            }


        }

        order_bt_addcard!!.setOnClickListener {
            loading.startLoadingDialog()
            Thread{
                prodcartr.prod_id = prod_id
                prodcartr.prod_baner = prod_ban
                prodcartr.prod_titel = order_txt_prodtitle!!.text.toString()
                prodcartr.prod_rest = order_txt_prodrest!!.text.toString()
                prodcartr.prod_qunty = order_txt_quanty!!.text.toString()
                prodcartr.prod_total = prod_total
                cartdO.InsertProd(prodcartr)
                val snackbar = Snackbar
                    .make(oder_lay, "Item Add In Cart", Snackbar.LENGTH_LONG)
                snackbar.show()

               // println("prod "+cartdO.getAllUsers().size)
              //  println("prod "+cartdO.getAllUsers().get(1).id)
               /* println("prod "+cartdO.getAllUsers().get(0).id)
                println("prod " +cartdO.getAllUsers().get(37).prod_id)
                println("prod " +cartdO.getAllUsers().get(37).prod_baner)
                println("prod " +cartdO.getAllUsers().get(37).prod_titel)
                println("prod " +cartdO.getAllUsers().get(37).prod_rest)
                println("prod " +cartdO.getAllUsers().get(37).prod_total)*/
                loading.dismissDialog()

                badgeHolderLayout!!.count = cartdO.getAllUsers().size
                // prodcartr.id  = cartdO.getAllUsers().get(0).id
                // cartdO.DeleteProd(prodcartr)
            }.start()





        }

        order_imgbt_likeuplike!!.setOnClickListener {

            println("testhelllo "+abc)

            if(abc.equals("1")){
                abc = "0"
                likeUnlikeApi(prod_id.toString(),"0")
                println("AV 1")
                println("testfav "+likeunlike)
                println("VA 0")
                Picasso.with(this)
                    .load(R.drawable.fav_icon)
                    .noFade()
                    .resize(5000,5000)
                    .onlyScaleDown()
                    .into(order_imgbt_likeuplike)

            }else if(abc.equals("0")){
                abc = "1"
                likeUnlikeApi(prod_id.toString(),"1")
                Picasso.with(this)
                    .load(R.drawable.favlike)
                    .noFade()
                    .resize(5000,5000)
                    .onlyScaleDown()
                    .into(order_imgbt_likeuplike)


            }
            /*if(ab == "1"){
                //likeUnlikeApi(prod_id.toString(),ab)
                ab = "0"
                println("testfav "+likeunlike)
                Picasso.with(this)
                    .load(R.drawable.favlike)
                    .noFade()
                    .resize(5000,5000)
                    .onlyScaleDown()
                    .into(order_imgbt_likeuplike)

                //order_imgbt_likeuplike!!.setImageDrawable(R.drawable.fav_icon)
            }else {
               // likeUnlikeApi(prod_id.toString(),ab)
                ab = "1"
                println("testun "+likeunlike)

                Picasso.with(this)
                    .load(R.drawable.fav_icon)
                    .noFade()
                    .resize(5000,5000)
                    .onlyScaleDown()
                    .into(order_imgbt_likeuplike)
            }*/

        }

    }


    fun likeUnlikeApi(pro_id: String, pro_like_unlike: String){
        loading.startLoadingDialog()
        homeRestuvm.HomeProdlike("3",pro_id,pro_like_unlike).observe(this, Observer { Resp->

            val snackbar = Snackbar
                .make(oder_lay, Resp.message, Snackbar.LENGTH_LONG)
            snackbar.show()
            loading.dismissDialog()
        })

    }
    fun OrderDetails(user_id:String,
                     product_id:String){
        loading.startLoadingDialog()
        ordervm.Order(user_id,product_id).observe(this, Observer { Resp->
            println("Check "+Resp);

            DataGet(Resp)
            var teba = JSONObject(Resp.toString())

            if(teba !=null && teba.getString("code").equals("200")){
                var  datajson = teba.getJSONObject("data")
                val ab = datajson.getString("product_title")
                println("sdfsadfsadfsadf "+ab)
                order_txt_prodtitle!!.setText(datajson.getString("product_title"))
                order_txt_prodrest!!.setText(datajson.getString("restaurent_name"))
                order_txt_price!!.setText(datajson.getString("product_price"))
                order_txt_start!!.setText(datajson.getString("avg_rating")+" Rating")
                val rati = datajson.getString("avg_rating")
                likeunlike = datajson.getString("likes")
                println("Raing "+rati.toFloat())
                order_ratimg_start!!.rating = rati.toFloat()
                readmore = ReadMoreOption.Builder(applicationContext).build()
                readmore.addReadMoreTo(order_txt_readmore,datajson.getString("product_detail"))
                //readmore.addReadMoreTo(order_txt_readmore,"sdfsdfsfsfsdfsdfsfsdf")

                prod_price = datajson.getString("product_price")
                prod_ban = datajson.getString("image")
                Picasso.with(this).load(prod_ban).into(order_img_banc);
                prod_total = prod_price
                order_txt_totalprice!!.setText("$ "+prod_price)

                abc = likeunlike.toString()

                if(likeunlike.equals("1")){
                    println("test "+likeunlike)
                    Picasso.with(this)
                        .load(R.drawable.favlike)
                        .noFade()
                        .resize(5000,5000)
                        .onlyScaleDown()
                        .into(order_imgbt_likeuplike)
                    //order_imgbt_likeuplike!!.setImageDrawable(R.drawable.fav_icon)
                }else if(likeunlike.equals("0")){
                    println("test "+likeunlike)
                    println("test "+likeunlike)
                    Picasso.with(this)
                        .load(R.drawable.fav_icon)
                        .noFade()
                        .resize(5000,5000)
                        .onlyScaleDown()
                        .into(order_imgbt_likeuplike)
                }

                loading.dismissDialog()

            }


        })
    }

    fun DataGet(main: JsonObject){
        var mainr : JSONObject?=null
        mainr= JSONObject(main.toString())
          if(mainr !=null && mainr.getString("code").equals("200")){
              var  datajson = mainr.getJSONObject("data")
              val ab = datajson.getString("product_title")
              println("sdfsd "+ab)
          }

    }

    fun inti(){
        order_img_banc = findViewById(R.id.order_img_banc)
        order_txt_prodtitle = findViewById(R.id.order_txt_prodtitle)
        order_txt_prodrest = findViewById(R.id.order_txt_prodrest)
        order_txt_price = findViewById(R.id.order_txt_price)
        order_txt_start = findViewById(R.id.order_txt_start)
        order_ratimg_start = findViewById(R.id.order_ratimg_start)
        order_txt_readmore = findViewById(R.id.order_txt_readmore)
        order_txt_quanty = findViewById(R.id.order_txt_quanty)
        order_txt_plus = findViewById(R.id.order_txt_plus)
        order_txt_subra = findViewById(R.id.order_txt_subra)
        order_txt_totalprice = findViewById(R.id.order_txt_totalprice)
        order_bt_addcard = findViewById(R.id.order_bt_addcard)
        order_bt_plaace = findViewById(R.id.order_bt_plaace)
    }





}
