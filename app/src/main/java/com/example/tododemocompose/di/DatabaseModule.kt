package com.example.tododemocompose.di

import android.content.Context
import androidx.room.Room
import com.example.tododemocompose.data.ToDoDatabase
import com.example.tododemocompose.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context)=
        Room.databaseBuilder(context, ToDoDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(toDoDatabase: ToDoDatabase)=toDoDatabase.toDoDao()

}