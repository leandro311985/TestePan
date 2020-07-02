package com.opah.android.testepan.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.opah.android.testepan.R
import com.opah.android.testepan.activity.CardActivity
import kotlinx.android.synthetic.main.item_info.view.*
import java.util.*

class InfoAdapter(
    val items: List<String>, val context: Context, val type: String
) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_info, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = items[position]

        val rnd = Random()
        val color =
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        holder.card.setBackgroundColor(color)

        holder.card.radius = 16.toDp(context).toFloat()
        holder.card.setOnClickListener {
            val type = type
            val intent = Intent(context, CardActivity::class.java)
            intent.putExtra("title", items[position])
            intent.putExtra("types", type)

            context.startActivity(intent)
        }

    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.text
    val card = view.card_id

}

fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
).toInt()