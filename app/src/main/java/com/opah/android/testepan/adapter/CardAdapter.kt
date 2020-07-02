package com.opah.android.testepan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.opah.android.testepan.R
import com.opah.android.testepan.model.CardModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_card.view.*


class CardAdapter : BaseAdapter {
    var cardList = listOf<CardModel>()
    var context: Context? = null

    constructor(context: Context, cardList: List<CardModel>) : super() {
        this.context = context
        this.cardList = cardList
    }

    override fun getCount(): Int {
        return cardList.size
    }

    override fun getItem(position: Int): Any {
        return cardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val card = this.cardList[position]

        val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val cardView = inflator.inflate(R.layout.item_card, null)

        cardView.testeTxt.text = card.name

        Picasso.get().load("https://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_319.png")
            .placeholder(R.mipmap.place_holder)
            .into(cardView.image_view)

        return cardView
    }


}


