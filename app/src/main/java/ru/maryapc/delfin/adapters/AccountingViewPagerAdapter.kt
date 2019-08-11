package ru.maryapc.delfin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class AccountingViewPagerAdapter(
    mFragmentManager: FragmentManager?

) : FragmentStatePagerAdapter(mFragmentManager) {

    private var mFragmentList: MutableList<Fragment> = mutableListOf()
    private var mTitleList: MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mTitleList.add(title)
    }
}