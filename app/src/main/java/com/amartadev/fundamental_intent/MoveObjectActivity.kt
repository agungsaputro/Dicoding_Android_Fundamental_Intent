package com.amartadev.fundamental_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)

        val tvRecieveObject: TextView = findViewById(R.id.tv_receive_object)

        val person = intent.getParcelableExtra(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()}, \nEmail: ${person.emai}, \nAge : ${person.age}, \nLocation : ${person.city} "
        tvRecieveObject.text = text
    }

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }
}
