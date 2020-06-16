package com.example.lanecrowd.util

import android.app.Application
import com.example.foodeze.util.Api
import com.example.lanecrowd.Session_Package.SessionManager
import com.example.lanecrowd.modal.repository.UserRepository
import com.example.lanecrowd.retrofit.ApiInterface
import com.example.lanecrowd.view_modal.factory.ViewModelFactoryC
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AppController : Application(), KodeinAware {


    //kodein declaration
    override val kodein = Kodein.lazy {
        import(androidXModule(this@AppController))


        bind() from singleton { SessionManager(instance()) }
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
       // bind() from singleton { Api(instance()) }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { ViewModelFactoryC(instance()) }
    }





}