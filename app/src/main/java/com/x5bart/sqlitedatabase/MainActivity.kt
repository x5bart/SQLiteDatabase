package com.x5bart.sqlitedatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsert.setOnClickListener {
            if (etName.text.toString().isNotEmpty() && etAge.text.toString().isNotEmpty()) {
                val user = User(etName.text.toString(), etAge.text.toString().toInt())
                val db = DataBaseHandler(this)
                db.insertData(user)
            } else {
                Toast.makeText(this, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
            }


        }

    }
}
