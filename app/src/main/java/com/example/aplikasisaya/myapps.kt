package com.example.aplikasisaya

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class myapps : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("biodata").build()
        Realm.setDefaultConfiguration(config)
    }
}