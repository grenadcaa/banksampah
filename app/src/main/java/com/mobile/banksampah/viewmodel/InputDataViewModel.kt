package com.mobile.banksampah.viewmodel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mobile.banksampah.database.DatabaseClient.Companion.getInstance
import com.mobile.banksampah.database.DatabaseDao
import com.mobile.banksampah.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers



class InputDataViewModel(application: Application) : AndroidViewModel(application) {

    var databaseDao: DatabaseDao?

    fun addDataSampah(
        nama_pengguna: String,
        jenis_sampah: String,
        berat: Int,
        harga: Int,
        tanggal: String,
        alamat: String,
        catatan: String
    ) {
        Completable.fromAction {
            val ModelDatabase = ModelDatabase()
            ModelDatabase.namaPengguna = nama_pengguna
            ModelDatabase.jenisSampah = jenis_sampah
            ModelDatabase.berat = berat
            ModelDatabase.harga = harga
            ModelDatabase.tanggal = tanggal
            ModelDatabase.alamat = alamat
            ModelDatabase.catatan = catatan
            databaseDao?.insertData(ModelDatabase)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    private fun ModelDatabase(): ModelDatabase {

    }




    init {
        databaseDao = getInstance(application)?.appDatabase?.databaseDao()
    }

}