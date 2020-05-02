package com.example.a17_sabaq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ozgerttiriw.*


class MainActivity : AppCompatActivity() {

    private val adapter: ListAdapter = ListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a: Int = intent.getIntExtra("position", 0)
        if(a!=0){
            var text1: String = intent.getStringExtra("title")
            var text2: String = intent.getStringExtra("description")
            val models: MutableList<User> = mutableListOf()
            val model = User()
            model.title = text1
            model.description = text2
            models.add(model)
            adapter.setData(models)
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData(1)

    }

    private fun setData(count: Int) {
        val models: MutableList<User> = mutableListOf()
        for(i in 0 until count) {
            val model = User()
            model.title = "Title ${i+1}"
            model.description = "Description ${i+1}"
            models.add(model)
        }
        adapter.setData(models)
    }

    fun onOptionsButtonClick(view: View, position: Int) {
        val optionsMenu = PopupMenu(this, view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.item_option, optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.itemAdd -> {
                    adapter.addUser(position+1)
                }
                R.id.edit ->{val dialog = AlertDialog.Builder(this)
                    dialog.setTitle("Anıq o'zgertejaqsizba?")
                    dialog.setMessage("Bul itemnin magliwmatlarin o'zgertiwdi qaleysizba?")
                    dialog.setCancelable(false)
                    dialog.setPositiveButton("Awa"
                    ) { dialog, which ->

                        val sms = Intent(this, Ozgerttiriw::class.java)
                        sms.putExtra("name", position)
                        startActivity(sms)
                    }
                    dialog.setNegativeButton("Yaq") {
                            dialog, which ->
                        dialog.dismiss()
                    }
                    dialog.setNeutralButton("Cancel"){
                            dialog, which ->
                        dialog.cancel()
                    }
                    dialog.show()
                }
                R.id.itemDelete -> {
                    val dialog = AlertDialog.Builder(this)
                    dialog.setTitle("O'shirejaqsizba?")
                    dialog.setMessage("O'shiriw ushin - awa, biykarlaw ushin yaq tuymesin basin!")
                    dialog.setCancelable(false)
                    dialog.setPositiveButton("Awa"
                    ) { dialog, which ->
                        adapter.removeUser(position)
                    }
                    dialog.setNegativeButton("Yaq") {
                                dialog, which ->
                            dialog.dismiss()
                        }
                    dialog.setNeutralButton("Cancel"){
                        dialog, which ->
                        dialog.cancel()
                    }
                    dialog.show()
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }
}
