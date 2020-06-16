package com.example.foodeze.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.foodeze.R
import org.jetbrains.anko.find

class ProgreessDig : AppCompatActivity() {
   lateinit var Bt:Button
   lateinit var loading:LoadingDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progreess_dig)
        Bt = findViewById(R.id.bt_start)
        loading = LoadingDialog(this)
        Bt.setOnClickListener {
            loading.startLoadingDialog()

        }
    }
}
