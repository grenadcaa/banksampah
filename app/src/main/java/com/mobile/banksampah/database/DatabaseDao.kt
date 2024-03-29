package com.mobile.banksampah.database

import androidx.room.Dao
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mobile.banksampah.model.ModelDatabase



@Dao // data akses objek
interface DatabaseDao {

    @Query("SELECT * FROM tbl_banksampah")
    fun getAll(): LiveData<List<ModelDatabase>>

    @Query("SELECT SUM(harga) FROM tbl_banksampah")
    fun getSaldo(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(modelDatabases: ModelDatabase)

    @Query("DELETE FROM tbl_banksampah WHERE id= :id")
    fun deleteSingleData(id: Int)

}