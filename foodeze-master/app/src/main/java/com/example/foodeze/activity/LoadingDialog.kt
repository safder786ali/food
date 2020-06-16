package com.example.foodeze.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.foodeze.R
import org.jetbrains.anko.layoutInflater

class LoadingDialog constructor(var conte: Context) {

    var Activity:Context=conte
    lateinit var dialog:AlertDialog

    fun startLoadingDialog(){
        var builder: AlertDialog.Builder = AlertDialog.Builder(Activity)
        var inflate:LayoutInflater = conte.layoutInflater
        builder.setView(inflate.inflate(R.layout.custom_dialog,null))
        builder.setCancelable(true)
        dialog = builder.create()
        dialog.show()
    }
    fun dismissDialog(){
        dialog.dismiss()
    }
}