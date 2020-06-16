package com.example.foodeze.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.adapter.HomeSlipderAdapter
import com.example.foodeze.adapter.MenuAdapter
import com.example.foodeze.model.HomeHeadModel
import com.example.foodeze.model.MenuModel

class MenuItem : AppCompatActivity() {
    private lateinit var menuitemRV: RecyclerView;
    var layoutLin : GridLayoutManager?=null
    var menulist:ArrayList<MenuModel> = ArrayList<MenuModel>()
    private var menuAdapter : MenuAdapter?=null
    lateinit var menumodel: MenuModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_item)
        menuitemRV = findViewById(R.id.menuitemRV);
        MenuItem()
        layoutLin = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)

        menuitemRV!!.setHasFixedSize(true)
        menuitemRV.scrollState
        menuitemRV!!.layoutManager = layoutLin
        menuAdapter = MenuAdapter(this, menulist)
        menuitemRV!!.adapter = menuAdapter
    }
    fun MenuItem(){
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
        menulist.add(MenuModel("sdf",""))
    }
}
