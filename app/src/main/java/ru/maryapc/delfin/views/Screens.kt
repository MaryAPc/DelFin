package ru.maryapc.delfin.views

import androidx.fragment.app.Fragment
import ru.maryapc.delfin.views.fragments.AccountingFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class AccountingScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return AccountingFragment()
        }
    }

    enum class ScreenName {
        ACCOUNTING
    }
}
