package com.todotask.app.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.todotask.app.models.TodoData

@Dao
interface TodoDao {

    @Query("SELECT * FROM TodoData")
    fun getAllTodo(): LiveData<List<TodoData>>

    @Insert
    fun addTodo(todo: TodoData)

    @Query("DELETE FROM TodoData where id = :id")
    fun deleteTodo(id: Int)
}