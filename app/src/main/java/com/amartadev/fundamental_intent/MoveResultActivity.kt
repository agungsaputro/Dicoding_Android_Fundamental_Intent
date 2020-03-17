package com.amartadev.fundamental_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rbNumber: RadioGroup
    private lateinit var btnChoose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_result)

        rbNumber = findViewById(R.id.rg_number)
        btnChoose = findViewById(R.id.btn_choose)

        btnChoose.setOnClickListener(this)
    }

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_choose){
            if (rbNumber.checkedRadioButtonId != 0){
                var value = 0
                when(rbNumber.checkedRadioButtonId){
                    R.id.rb_50 -> value = 50
                    R.id.rb_100 -> value = 100
                    R.id.rb_150 -> value = 150
                    R.id.rb_200 -> value = 200
                }
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }

    }
}
