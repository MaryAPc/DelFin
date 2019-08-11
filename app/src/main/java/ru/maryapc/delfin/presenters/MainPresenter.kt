package ru.maryapc.delfin.presenters

import ru.maryapc.delfin.DelFinApplication
import ru.maryapc.delfin.views.Screens
import ru.maryapc.delfin.views.interfaces.MainView
import ru.terrakok.cicerone.Router

class MainPresenter: BasePresenter<MainView>() {
    private var mRouter: Router = DelFinApplication.instance.router

    fun setupRootScreen() {
        mRouter.newRootScreen(Screens.AccountingScreen())
    }
}