package ru.maryapc.delfin.presenters

import ru.maryapc.delfin.views.interfaces.BaseView

abstract class BasePresenter<V : BaseView> {

    private var mView: V? = null

    fun attachView(view: V?) {
        this.mView = view
    }

    fun detachView() {
        mView = null
    }

    fun getView(): V? {
        return mView
    }

    fun isViewAttached(): Boolean {
        return mView != null
    }
}