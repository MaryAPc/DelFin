package ru.maryapc.delfin.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.tabs.TabLayout
import ru.maryapc.delfin.R
import ru.maryapc.delfin.adapters.AccountingViewPagerAdapter

class AccountingFragment : Fragment() {

    @BindView(R.id.fragment_accounting_view_pager)
    lateinit var mViewPager: ViewPager

    lateinit var mTabs: TabLayout

    private lateinit var mViewPagerAdapter: AccountingViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewPagerAdapter = AccountingViewPagerAdapter(fragmentManager)

        with(mViewPagerAdapter) {
            addFragment(ExpensesFragment(), "Расходы")
            addFragment(ExpensesFragment(), "Доходы")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_accounting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ButterKnife.bind(this, view)

        mTabs = activity!!.findViewById(R.id.activity_main_tabs)
        mViewPager.adapter = mViewPagerAdapter
        mTabs.setupWithViewPager(mViewPager)
    }
}