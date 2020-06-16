package com.ff.deptmanager.fragment


import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.activity.LoadingDialog
import com.example.foodeze.adapter.HomeAllProductsAdapter
import com.example.foodeze.adapter.HomeAllProductsItemAdapter
import com.example.foodeze.adapter.HomeSlipderAdapter
import com.example.foodeze.model.HomeHeadModel
import com.example.foodeze.model.HomeItemProductModel
import com.example.foodeze.model.HomeProductModel
import com.example.foodeze.viewmodal.factory.HomeRestruVM
import com.example.lanecrowd.view_modal.factory.ViewModelFactoryC
import com.google.android.material.snackbar.Snackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class RestrauFragment : Fragment(), HomeAllProductsItemAdapter.HomeAllProd {
    override fun HomeProdlike(pro_id: String, pro_like_unlike: String) {
        if(pro_like_unlike.equals("1")){
            println("test "+pro_id+"0")
            likeUnlikeApi(pro_id,"0")



            //HomeProduct()
           // mostPopularRV.smoothScrollToPosition(homeProitemAdapter!!.itemCount-1)
        }else if(pro_like_unlike.equals("0")){
            println("test "+pro_id+"1")
            likeUnlikeApi(pro_id,"1")

           //

        }
        //HomeProduct()
        /*Proitemlist.remove(position);
        recycler.removeViewAt(position);
        mAdapter.notifyItemRemoved(position);
        mAdapter.notifyItemRangeChanged(position, list.size())*/
       // likeUnlikeApi(pro_id,pro_like_unlike)


    }

    private lateinit var SlHeadRv: RecyclerView;
    var layoutLin : LinearLayoutManager?=null
    var Slheadlist:ArrayList<HomeHeadModel> = ArrayList<HomeHeadModel>()
    private var homeSlAdapter : HomeSlipderAdapter?=null
    lateinit var homeheadmode: HomeHeadModel


    private lateinit var productRV: RecyclerView;
    var prolayoutLin : LinearLayoutManager?=null
    var Prolist:ArrayList<HomeProductModel> = ArrayList<HomeProductModel>()
    private var homeProAdapter : HomeAllProductsAdapter?=null
    lateinit var homepromode: HomeProductModel


    private lateinit var mostPopularRV: RecyclerView;
    var ProitemLin : LinearLayoutManager?=null
    var Proitemlist:ArrayList<HomeItemProductModel> = ArrayList<HomeItemProductModel>()
    private var homeProitemAdapter : HomeAllProductsItemAdapter?=null
    lateinit var homeitempromode: HomeItemProductModel




    lateinit var views:View
   lateinit var rootlay: ConstraintLayout
    lateinit var homeRestuvm:HomeRestruVM
    lateinit var loading: LoadingDialog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        views = inflater.inflate(R.layout.fragment_restrau, container, false)
        rootlay = views.findViewById(R.id.rootlay)
        loading = LoadingDialog(views.context)
        init()
        Head()
       // AllProduct()

        homeRestuvm = ViewModelProvider(this).get(HomeRestruVM::class.java)
        HomeCate()
        HomeProduct()

        layoutLin = LinearLayoutManager(views.context)
        layoutLin!!.orientation = SlHeadRv.horizontalFadingEdgeLength
        SlHeadRv!!.setHasFixedSize(true)
        SlHeadRv.scrollState
        SlHeadRv!!.layoutManager = layoutLin
        homeSlAdapter = HomeSlipderAdapter(views.context, Slheadlist)
        SlHeadRv!!.adapter = homeSlAdapter
        //homeProAdapter!!.notifyDataSetChanged()



       // homeProitemAdapter!!.notifyDataSetChanged()



      //  homeProitemAdapter!!.notifyDataSetChanged()

        return views
    }
     fun init(){
         SlHeadRv = views.findViewById(R.id.sliderRV)
         productRV = views.findViewById(R.id.productRV)
         mostPopularRV = views.findViewById(R.id.mostPopularRV)
     }
     fun likeUnlikeApi(pro_id: String, pro_like_unlike: String){
         loading.startLoadingDialog()
         homeRestuvm.HomeProdlike("3",pro_id,pro_like_unlike).observe(viewLifecycleOwner, Observer { Resp->

             val snackbar = Snackbar
                 .make(rootlay, Resp.message, Snackbar.LENGTH_LONG)
             snackbar.show()
             loading.dismissDialog()
         })

     }
     fun HomeCate(){
         loading.startLoadingDialog()
         homeRestuvm.HomeRestu().observe(viewLifecycleOwner, Observer { Resp->
             println(Resp.code)
             for(i in 0 until Resp.data.size){
                 Prolist.add(HomeProductModel(Resp.data[i].id,Resp.data[i].category_title,
                     Resp.data[i].image))
             }
             prolayoutLin = LinearLayoutManager(views.context)
             prolayoutLin!!.orientation = productRV.horizontalFadingEdgeLength
             productRV!!.setHasFixedSize(true)
             productRV.scrollState
             productRV!!.layoutManager = prolayoutLin
             homeProAdapter = HomeAllProductsAdapter(views.context, Prolist)

             productRV!!.adapter = homeProAdapter
            loading.dismissDialog()
         })
     }
     fun HomeProduct(){
         homeRestuvm.HomeProduct().observe(viewLifecycleOwner, Observer { Resp->
            for(i in 0 until  Resp.data.size){
                Proitemlist.add(HomeItemProductModel(Resp.data[i].id,
                    Resp.data[i].product_title,
                    Resp.data[i].restaurent_name,
                    Resp.data[i].product_price,
                    Resp.data[i].product_discount,
                    Resp.data[i].image,
                    Resp.data[i].best_seller,
                    Resp.data[i].likes
                    ))
            }



             ProitemLin = LinearLayoutManager(views.context)
             ProitemLin!!.orientation = mostPopularRV.horizontalFadingEdgeLength
             mostPopularRV!!.setHasFixedSize(true)
             mostPopularRV.scrollState
             mostPopularRV!!.layoutManager = ProitemLin
             homeProitemAdapter = HomeAllProductsItemAdapter(views.context, Proitemlist,this)

             mostPopularRV!!.adapter = homeProitemAdapter
             // mostPopularRV.smoothScrollToPosition(homeProitemAdapter!!.itemCount)
             mostPopularRV.invalidate();
             homeProitemAdapter!!.notifyDataSetChanged()


        })


    }

    private fun Head(){
        Slheadlist.add(HomeHeadModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Slheadlist.add(HomeHeadModel("","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
    }
  /*  private fun AllProduct(){
        Prolist.add(HomeProductModel("","Product 1 asdfs","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Prolist.add(HomeProductModel("","Product 1 asdfsadf","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Prolist.add(HomeProductModel("","Product 1asd ","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Prolist.add(HomeProductModel("","Product 1asdf","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Prolist.add(HomeProductModel("","Product 1asdfs","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Prolist.add(HomeProductModel("","Product 1 sdfsadf","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Prolist.add(HomeProductModel("","Product 1","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Prolist.add(HomeProductModel("","Product 1","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Prolist.add(HomeProductModel("","Product 1","https://images.pexels.com/photos/3864682/pexels-photo-3864682.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
    }
*/
   /* private  fun MostPopralItem(){
        Proitemlist.add(HomeItemProductModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Proitemlist.add(HomeItemProductModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Proitemlist.add(HomeItemProductModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))
        Proitemlist.add(HomeItemProductModel("","https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"))

    }*/


}
