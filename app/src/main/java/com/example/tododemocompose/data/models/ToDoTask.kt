package com.example.tododemocompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.to_docompose.data.models.Priority
import com.example.tododemocompose.util.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)