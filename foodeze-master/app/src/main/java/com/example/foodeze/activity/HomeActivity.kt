package com.example.foodeze.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import com.example.foodeze.R
import com.example.foodeze.retrofit.GetLastIdCallback
import com.example.lanecrowd.Session_Package.SessionManager
import com.ff.deptmanager.fragment.*
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import kotlinx.android.synthetic.main.activity_home.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class HomeActivity : AppCompatActivity() , KodeinAware {





    private val session: SessionManager by instance()
    override val kodein by kodein()


    var ab:String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        ab = intent.getStringExtra("cart_id")
        println("text "+ab)
        if(ab.isNullOrEmpty()){
            loadFragment(RestrauFragment())
        }else if(ab.equals("fgg")){
            println("textsd "+ab)
            var fragment: Fragment? = null
            fragment = CartFragment()
            loadFragment(fragment)

        }
        setUpBottomNavigation()
        logoutUser()

    }


    private fun logoutUser() {

        /*logout.setOnClickListener{
            session.logoutUser()
        }*/


    }

    private fun setUpBottomNavigation() {
        bottom_navigation_view_linear.setOnNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.home -> {
                    fragment = RestrauFragment()
                   // println("test "+item.itemId)
                }
                R.id.orders -> {
                    fragment = OderFragment()
                   // println("test "+item.itemId)

                }
                R.id.carts -> {
                    fragment = CartFragment()
                   // println("test "+item.itemId)
                }
                R.id.events -> {
                    fragment = EventFragment()
                   // println("test "+item.itemId)
                }
                R.id.profile -> {
                    fragment = ProfileFragment()
                   // println("test "+item.itemId)
                }


            }
            loadFragment(fragment)
        }

    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }


    var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {


        if (doubleBackToExitPressedOnce) {
            finishAffinity()
            //  super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true

        DynamicToast.make(applicationContext, "Please click back again to exit").show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)


    }

}
