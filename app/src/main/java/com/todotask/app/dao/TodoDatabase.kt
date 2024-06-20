package com.todotask.app.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.todotask.app.models.TodoData
import com.todotask.app.utils.Converters

@Database(entities = [TodoData::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {
    companion object {
        const val NAME = "TODO_DB"
    }

    abstract fun getToDao(): TodoDao
}