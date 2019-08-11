package ru.maryapc.delfin.di.modules

import dagger.Module
import dagger.Provides
import ru.maryapc.delfin.di.annotations.ApplicationScope
import ru.maryapc.delfin.presenters.MainPresenter

@Module
class PresentersModule {

    @Provides
    @ApplicationScope
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }
}