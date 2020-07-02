package com.opah.android.testepan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Loading : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.LoadingDialog)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.loading_layout, container, false)

        isCancelable = false

        return view
    }

    companion object {

        const val TAG = "loading"

        fun showLoading(fragmentManager: FragmentManager) {
            fragmentManager?.let { it ->
                val transaction: FragmentTransaction = it.beginTransaction()
                val fragment: Loading? = it.findFragmentByTag(TAG) as Loading?

                fragment?.let {
                    return
                }
                transaction.addToBackStack(null)
                Loading().show(transaction, TAG)
            }

        }

        fun dismiss(fragmentManager:FragmentManager) {
            fragmentManager?.let {
                val fragment: Loading? = it.findFragmentByTag(TAG) as Loading?
                fragment?.dismiss()
            }

        }
    }
}