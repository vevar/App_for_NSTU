package com.gwsf.appfornstu

import android.app.Application
import android.content.Context
import com.gwsf.appfornstu.network.RetrofitProvider


class App: Application() {


    private lateinit var retrofitProvider: RetrofitProvider


    companion object {
        fun getApp(context: Context): App {
            return context.applicationContext as App
        }

        fun getRetrofitProvider(context: Context): RetrofitProvider {
            return getApp(context).retrofitProvider
        }



//        fun getAppDataBase(context: Context): AppDataBase {
//            return getApp(context).dataBase
//        }

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