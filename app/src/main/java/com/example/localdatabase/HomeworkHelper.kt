package com.example.localdatabase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import com.example.localdatabase.DatabaseContract.HomeworkColumns.Companion.TABLE_NAME
import com.example.localdatabase.DatabaseContract.HomeworkColumns.Companion._ID

class HomeworkHelper(context: Context) {

    private val dataBaseHelper: DataBaseHelper = DataBaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME
        private var INSTANCE: HomeworkHelper? = null

        fun getInstance(context: Context): HomeworkHelper =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: HomeworkHelper(context)
            }
    }

    @Throws(SQLException::class)
    fun open() {
        database = dataBaseHelper.writableDatabase
    }

    fun close() {
        dataBaseHelper.close()
        if (database.isOpen)
            database.close()

        }


    fun queryAll(): Cursor {
        return database.query(
            TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            "$_ID ASC",
            null
        )
    }

    fun insert(values: ContentValues?): Long {
        return database.insert(TABLE_NAME, null, values)
    }

    fun update(id: String, values: ContentValues?): Int {
        return database.update(TABLE_NAME, values, "$_ID = ?", arrayOf(id))
    }

    fun deleteById(id: String): Int {
        return database.delete(TABLE_NAME, "$_ID = ?", arrayOf(id))
    }
}
