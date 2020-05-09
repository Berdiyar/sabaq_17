package com.example.a17_sabaq

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom.*


class Custom_class(context: Context, activity: MainActivity): Dialog(context){

    val s = activity.position_1
    val lv = activity.adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom)

        recyclerView.adapter = lv
        recyclerView.layoutManager = GridLayoutManager(context, 5, GridLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        setData(50)

        btnCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun setData(count: Int) {
        val models: MutableList<User> = mutableListOf()
        for (i in 0 until count){
            val model = User()
            model.title = "${i+1}"
            models.add(model)
        }
        lv.setData(models)
    }
}