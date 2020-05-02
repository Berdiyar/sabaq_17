package com.example.a17_sabaq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.ozgerttiriw.*

class Ozgerttiriw : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ozgerttiriw)

        var a = intent.getIntExtra("name", 0)
        val text1 = editTitle.toString()
        val text2 = editDescription.toString()

        orinlaw.setOnClickListener {
        val sms = Intent(this, MainActivity::class.java)
            sms.putExtra("int", a)
            sms.putExtra("title", text1)
            sms.putExtra("description", text2)
            startActivity(sms)
            finish()
        }


    }
}
