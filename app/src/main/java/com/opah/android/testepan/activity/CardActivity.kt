package com.opah.android.testepan.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.opah.android.testepan.R
import com.opah.android.testepan.adapter.CardAdapter
import com.opah.android.testepan.model.CardModel
import kotlinx.android.synthetic.main.activity_card.*
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardActivity : AppCompatActivity() {
    private val viewModel: CardViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        progress_card.visibility = View.VISIBLE
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            onBackPressed()
        }

        val intent = intent
        val title = intent.getSerializableExtra("title") as String
        val type = intent.getSerializableExtra("types") as String
        setupObservers(type = type, classes = title)
        txt.text = type

    }

    private fun setupObservers(type: String, classes: String) {
        viewModel.getCardLiveData(type, classes).observe(this, Observer { responseCard(it) })
    }

    private fun responseCard(response: List<CardModel>) {
        if (response.isNotEmpty()) {
            progress_card.visibility = View.GONE

            recycler_view_card.apply {
                adapter = CardAdapter(this@CardActivity, response)
                adapter = adapter

            }
        }
    }

}


