package ru.maryapc.delfin.views.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.appbar.CollapsingToolbarLayout
import ru.maryapc.delfin.DelFinApplication
import ru.maryapc.delfin.R
import ru.maryapc.delfin.presenters.MainPresenter
import ru.maryapc.delfin.views.interfaces.MainView
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @BindView(R.id.activity_main_drawer_layout)
    lateinit var mDrawerLayout: DrawerLayout

    @BindView(R.id.activity_main_toolbar)
    lateinit var mToolbar: Toolbar

    @BindView(R.id.activity_main_collapsing_toolbar)
    lateinit var mCollapsingToolbarLayout: CollapsingToolbarLayout

    @Inject
    lateinit var mPresenter: MainPresenter

    private lateinit var mNavigator: SupportAppNavigator
    private lateinit var mNavigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        setSupportActionBar(mToolbar)

        val appBarDrawerToggle = ActionBarDrawerToggle(
            this, mDrawerLayout, mToolbar,
            R.string.Open,
            R.string.Close
        )
        mDrawerLayout.addDrawerListener(appBarDrawerToggle)
        appBarDrawerToggle.syncState()

        DelFinApplication.appComponent.inject(this)

        mNavigator = SupportAppNavigator(this, R.id.activity_main_frame_container)
        mNavigatorHolder = DelFinApplication.instance.navigatorHolder

        mPresenter.attachView(this)
        mPresenter.setupRootScreen()
    }

    override fun onResume() {
        super.onResume()
        mNavigatorHolder.setNavigator(mNavigator)
    }

    override fun onPause() {
        super.onPause()
        mNavigatorHolder.removeNavigator()
    }
}
