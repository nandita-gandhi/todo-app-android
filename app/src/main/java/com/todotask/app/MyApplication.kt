package com.todotask.app

import android.app.Application
import androidx.room.Room
import com.todotask.app.dao.TodoDatabase

class MyApplication : Application() {

    companion object {
        lateinit var todoDatabase: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase =
            Room.databaseBuilder(
                applicationContext,
                TodoDatabase::class.java,
                TodoDatabase.NAME
            ).build()
    }
}