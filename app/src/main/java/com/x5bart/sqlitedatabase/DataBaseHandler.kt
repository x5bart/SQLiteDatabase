package com.x5bart.sqlitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DATABASE_NAME = "MyDB"
const val TABLE_NAME = "Users"
const val COL_NAME = "name"
const val COL_AGE = "age"
const val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable =
            "CREATE TABLE $TABLE_NAME (" +
                    "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COL_NAME VARCHAR(256), " +
                    "$COL_AGE INTEGER)"

        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersioun: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(user: User) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_AGE, user.age)
        val result = db.insert(TABLE_NAME, null, cv)
        if (result == (-1).toLong()) Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}
