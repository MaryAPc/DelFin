package ru.maryapc.delfin.di.components

import dagger.Component
import ru.maryapc.delfin.di.annotations.ApplicationScope
import ru.maryapc.delfin.di.modules.PresentersModule
import ru.maryapc.delfin.views.activities.MainActivity

@ApplicationScope
@Component(modules = [PresentersModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}