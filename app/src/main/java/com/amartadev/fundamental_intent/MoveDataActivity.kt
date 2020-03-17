package com.amartadev.fundamental_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data)

        val txtRecieveData: TextView = findViewById(R.id.tv_receive_data)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE,0)

        val text = " nama : $name , umur : $age"
        txtRecieveData.text = text
    }

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_name"
    }
}
