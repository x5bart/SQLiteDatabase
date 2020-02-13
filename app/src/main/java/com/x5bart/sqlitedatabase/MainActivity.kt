package com.x5bart.sqlitedatabase

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val db = DataBaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnInsert.setOnClickListener {
            insertDB()
            readDB()
        }

        btnRead.setOnClickListener {
            readDB()
        }

        btnUpdate.setOnClickListener {
            db.updateDate()
            readDB()
        }

        btnDelete.setOnClickListener {
            db.deleteData()
            readDB()
        }
    }

    private fun readDB() {
        val data = db.readData()
        tvResults.text = ""
        for (i in 0 until data.size) {
            tvResults.append("${data[i].id} ${data[i].name} ${data[i].age}\n")
        }
    }

    private fun insertDB(){
        if (etName.text.toString().isNotEmpty() && etAge.text.toString().isNotEmpty()) {
            val user = User(etName.text.toString(), etAge.text.toString().toInt())
            db.insertData(user)
        } else {
            Toast.makeText(this, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
        }
    }
}
