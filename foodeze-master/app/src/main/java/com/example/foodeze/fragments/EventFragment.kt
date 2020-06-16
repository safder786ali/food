package com.ff.deptmanager.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.foodeze.R
import com.example.foodeze.activity.CreateEvent
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_event.*

class EventFragment : Fragment() {

    lateinit var views:View

    var constranlay:ConstraintLayout?=null
    var eventrv:RecyclerView?=null
    var Event_bt:Button?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        views = inflater.inflate(R.layout.fragment_event, container, false)
        constranlay = views.findViewById(R.id.event_layfirst)
        eventrv = views.findViewById(R.id.eventrv)
        Event_bt = views.findViewById(R.id.Event_bt)

        Event_bt!!.setOnClickListener {
             startActivity(Intent(views.context,CreateEvent::class.java))
            val snackbar = Snackbar
                .make(event_layfirst, "hello", Snackbar.LENGTH_LONG)
            snackbar.show()

        }


        return views
    }


}
