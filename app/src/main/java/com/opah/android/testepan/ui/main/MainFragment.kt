package com.opah.android.testepan.ui.main

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.card.MaterialCardView
import com.opah.android.testepan.adapter.InfoAdapter
import com.opah.android.testepan.Loading
import com.opah.android.testepan.R
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        var types = "types"
        var races = "races"
        var classes = "classes"
    }

    private val viewModel: MainViewModel by viewModel()

    var cardView: MaterialCardView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        cardView?.findViewById<MaterialCardView>(R.id.card_id)
        fragmentManager?.let { it1 -> Loading.showLoading(it1) }

        onResponse()
    }

    private fun onResponse() {
        viewModel.infoLiveData.observe(viewLifecycleOwner, Observer {

            if (it != null){
                fragmentManager?.let { it1 -> Loading.dismiss(it1) }
            }

            recycler_view.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                adapter = InfoAdapter(
                    it.classes,
                    context,classes
                )
            }

            recycler_view_Races.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                adapter = InfoAdapter(
                    it.races,
                    context, races
                )
            }

            recycler_view_Types.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                adapter = InfoAdapter(
                    it.types,
                    context, types
                )
            }

        })
        viewModel.infoLiveData

    }

}

