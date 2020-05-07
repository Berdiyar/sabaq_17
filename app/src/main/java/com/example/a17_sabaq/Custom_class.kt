package com.example.a17_sabaq

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.*


class Custom_class(context: Context, activity: MainActivity, position: Int): Dialog(context){

    val a = activity.adapter
    val b = position

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)

        val dialog = AlertDialog.Builder(context)
        btnOk.setOnClickListener {
            a.addUser(b+1, edit_Text.text.toString(), edit_Text_Des.text.toString())
            dismiss()
        }
        btnCancel.setOnClickListener {
            dismiss()
        }


    }

}