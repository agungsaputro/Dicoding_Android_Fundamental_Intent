package com.amartadev.fundamental_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity: Button = findViewById(R.id.button_intent)
        btnPindahActivity.setOnClickListener(this)

        val btnPindahDataActivity: Button = findViewById(R.id.btn_move_data)
        btnPindahDataActivity.setOnClickListener(this)

        val btnPindahObjekActivity: Button = findViewById(R.id.btn_move_objek)
        btnPindahObjekActivity.setOnClickListener(this)

        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        val btnMoveResult: Button = findViewById(R.id.btn_move_result)
        btnMoveResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_move_result)
    }
    companion object{
        private const val REQUEST_CODE = 100
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button_intent ->{
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_data ->{
                val moveDataIntent = Intent(this@MainActivity, MoveDataActivity::class.java)
                moveDataIntent.putExtra(MoveDataActivity.EXTRA_NAME, "fucek")
                moveDataIntent.putExtra(MoveDataActivity.EXTRA_AGE, 5)
                startActivity(moveDataIntent)
            }
            R.id.btn_move_objek ->{
                val person = Person(
                    "Fucek",
                    19,
                    "fucek@gmail.com",
                    "Semarang"
                )

                val moveObjectIntent = Intent(this@MainActivity, MoveObjectActivity::class.java)
                moveObjectIntent.putExtra(MoveObjectActivity.EXTRA_PERSON, person)
                startActivity(moveObjectIntent)
            }
            R.id.btn_dial_number ->{
                val phoneNumber = "085729785625"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_result ->{
                val moveResultIntent = Intent(this@MainActivity, MoveResultActivity::class.java)
                startActivityForResult(moveResultIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil: $selectedValue"
            }
        }
    }
}
