package com.welooky.welook.support

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

open class LazyFragment : Fragment() {
    private var isFragmentVisible: Boolean = false
    private var isReuseView = false
    private var isFirstVisible = false
    private var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariable()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (rootView == null) {
            rootView = view
            if (userVisibleHint) {
                if (isFirstVisible) {
                    onFragmentFirstVisible()
                    isFirstVisible = false
                }
                onFragmentVisibleChange(true)
                isFragmentVisible = true
            }
        }
        super.onViewCreated(if (isReuseView) rootView!! else view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        initVariable()
    }

    protected fun onFragmentVisibleChange(visble: Boolean) {

    }

    protected fun onFragmentFirstVisible() {

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (rootView == null) {
            return
        }
        if (isFirstVisible && isVisibleToUser) {
            onFragmentFirstVisible()
            isFirstVisible = false
        }
        if (isVisibleToUser) {
            onFragmentVisibleChange(true)
            isFragmentVisible = true
            return
        }
        if (isFragmentVisible) {
            isFragmentVisible = false
            onFragmentVisibleChange(false)
        }
    }

    protected fun isFragmentVisble(): Boolean {
        return isFragmentVisible
    }

    private fun initVariable() {
        isFirstVisible = true
        isFragmentVisible = false
        rootView = null
        isReuseView = true
    }
}