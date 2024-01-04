package com.mobile.banksampah.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.mobile.banksampah.database.DatabaseClient.Companion.getInstance
import com.mobile.banksampah.database.DatabaseDao
import com.mobile.banksampah.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class RiwayatViewModel(application: Application) : AndroidViewModel(application) {

    var totalSaldo: LiveData<Int>
    var dataBank: LiveData<List<ModelDatabase>>
    var databaseDao: DatabaseDao?

    fun deleteSingleData(uid: Int) {
        Completable.fromAction {
            databaseDao?.deleteSingleData(uid)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun deleteDataById(uid: Int) {
        TODO("Not yet implemented")
    }

    init {
        databaseDao = getInstance(application)?.appDatabase?.databaseDao()
        dataBank = DatabaseDao.getAll()
        totalSaldo = DatabaseDao.getSaldo()
    }

}
