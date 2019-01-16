package com.alxminyaev.appfornstu

import android.app.Application
import androidx.room.Room
import android.content.Context
import com.alxminyaev.appfornstu.database.AppDataBase
import com.alxminyaev.appfornstu.network.RetrofitProvider


class App: Application() {

    lateinit var retrofitProvider: RetrofitProvider

    lateinit var dataBase: AppDataBase

    companion object {
        fun getApp(context: Context): App {
            return context.applicationContext as App
        }

        fun getRetrofitProvider(context: Context): RetrofitProvider {
            return getApp(context).retrofitProvider
        }

        fun getAppDataBase(context: Context): AppDataBase {
            return getApp(context).dataBase
        }

    }

    override fun onCreate() {
        super.onCreate()

//        retrofitProvider = RetrofitProvider()
//
//        dataBase = Room.databaseBuilder(
//            getApp(this),
//            AppDataBase::class.java,
//            AppDataBase.DATABASE_NAME
//        ).build()
    }

}