package com.todotask.app.utils

import com.todotask.app.models.TodoData
import java.time.Instant
import java.util.*

// Saves in memory
//object TodoManager {
//
//    private val toDoList = mutableListOf<TodoData>()
//
//    fun getAllTodo(): List<TodoData> {
//        return toDoList
//    }
//
//    fun addTodo(title: String) {
//        toDoList.add(
//            TodoData(
//                id = System.currentTimeMillis().toInt(),
//                title = title,
//                createdAt = Date.from(Instant.now())
//            )
//        )
//    }
//
//    fun deleteTodo(id: Int) {
//        toDoList.removeIf { item -> item.id == id }
//    }
//}