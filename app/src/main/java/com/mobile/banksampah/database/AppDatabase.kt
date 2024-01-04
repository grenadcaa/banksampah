package com.mobile.banksampah.database

import androidx.room.Database
import androidx.room.RoomDatabase

import com.mobile.banksampah.model.ModelDatabase



@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}