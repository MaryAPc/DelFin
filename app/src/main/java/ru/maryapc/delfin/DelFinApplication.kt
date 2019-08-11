package ru.maryapc.delfin

import android.app.Application
import ru.maryapc.delfin.di.components.AppComponent
import ru.maryapc.delfin.di.components.DaggerAppComponent
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


class DelFinApplication : Application() {
    private lateinit var mCicerone: Cicerone<Router>

    val navigatorHolder: NavigatorHolder
        get() = mCicerone.navigatorHolder

    val router: Router
        get() = mCicerone.router

    companion object {
        lateinit var appComponent: AppComponent
        lateinit var instance: DelFinApplication
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        appComponent = DaggerAppComponent.builder().build()

        mCicerone = Cicerone.create()
    }
}