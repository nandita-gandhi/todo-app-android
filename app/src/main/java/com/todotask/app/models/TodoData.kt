package com.todotask.app.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class TodoData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val title: String,
    val createdAt: Date,
)
