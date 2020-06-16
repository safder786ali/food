package com.ff.deptmanager.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.activity.HomeActivity
import com.example.foodeze.adapter.CartAdatper
import com.example.foodeze.adapter.OrderAdatper
import com.example.foodeze.model.CartModel
import com.example.foodeze.model.OrderModel
import com.example.foodeze.room.CartDAO
import com.example.foodeze.room.CartDataBase
import com.example.foodeze.room.HirstoryDAO
import com.example.foodeze.util.ReadMoreOption
import com.steelkiwi.library.view.BadgeHolderLayout
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class OderFragment : Fragment() {

    lateinit var views:View
    var txtde:TextView?=null
    lateinit var readmore:ReadMoreOption
    var cont:OderFragment= this@OderFragment
    lateinit var histget: HirstoryDAO
   private var orderad: OrderAdatper?=null
    var oderalist:ArrayList<OrderModel> = ArrayList<OrderModel>()
    private lateinit var oderrv: RecyclerView;
    var layoutLin : LinearLayoutManager?=null
    var badgeHolderLayout: BadgeHolderLayout?=null
    lateinit var cartdO: CartDAO
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        views = inflater.inflate(R.layout.fragment_order, container, false)

        badgeHolderLayout = views.findViewById(R.id.badgetholder)
        doAsync {
            cartdO = CartDataBase.getDatabase(cont.requireContext()).cartDAO()
            badgeHolderLayout!!.count = cartdO.getAllUsers().size
        }
        badgeHolderLayout!!.setOnClickListener {
            val intent : Intent = Intent(cont.requireContext(), HomeActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.putExtra("cart_id","fgg")
            startActivity(intent)
        }
        oderrv = views.findViewById(R.id.orderrv)
/*
        Thread{
            histget = CartDataBase.getDatabase(views.context).historyDAO();
            println("orider "+histget.getAllHistory().size)
            for (i in 0 until histget.getAllHistory().size){
                oderalist.add(OrderModel("sdfsdf",
                    "sdfsdf",
                    "sdfs",
                    "ssdf",
                    "dsfsdf"))
            }
            *//*oderalist.add(OrderModel(histget.getAllHistory().get(i).prod_id,
                histget.getAllHistory().get(i).prod_baner.toString(),
                histget.getAllHistory().get(i).prod_titel,
                histget.getAllHistory().get(i).prod_rest,
                histget.getAllHistory().get(i).prod_total))*//*



        }.start()*/
        oderdatea()

        ///txtde = views.findViewById(R.id.txtdetails)
        //readmore =ReadMoreOption.Builder(views.context).build()
        // readmore.addReadMoreTo(txtde,"sdfsaf")

        return views
    }

    fun oderdatea() {
      /*  Thread {
            oderalist.add(
                OrderModel(
                    "sdfsdf",
                    "sdfsdf",
                    "sdfs",
                    "ssdf",
                    "dsfsdf"
                )
            )
            println("orider " + histget.getAllHistory().size)
            *//*for (i in 0 until histget.getAllHistory().size){
               *//**//* *//**//*
            }*//*



        }.start()*/

        doAsync {
            histget = CartDataBase.getDatabase(views.context).historyDAO();
            for (i in 0 until histget.getAllHistory().size) {
                oderalist.add(
                    OrderModel(
                        histget.getAllHistory().get(i).prod_id,
                        histget.getAllHistory().get(i).prod_baner.toString(),
                        histget.getAllHistory().get(i).prod_titel,
                        histget.getAllHistory().get(i).prod_rest,
                        histget.getAllHistory().get(i).prod_total
                    )
                )
            }

            uiThread {
                layoutLin = LinearLayoutManager(views.context)
                layoutLin!!.orientation = LinearLayoutManager.VERTICAL
                oderrv!!.setHasFixedSize(true)
                oderrv.scrollState
                oderrv!!.layoutManager = layoutLin
                orderad = OrderAdatper(views.context, oderalist)
                oderrv!!.adapter = orderad
                orderad!!.notifyDataSetChanged()
            }


        }
    }


}
