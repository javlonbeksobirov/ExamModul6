package com.b12game.exammodul6.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.b12game.exammodul6.R
import com.b12game.exammodul6.model.CardAppModel

class CardAdapter(var context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var cardList = ArrayList<CardAppModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addcard(card: ArrayList<CardAppModel>) {
        cardList.addAll(card)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cardItem = cardList[position]

        if (holder is CardViewHolder) {
            holder.cardName.text = cardItem.cardName.toString()
            holder.cardDate.text = cardItem.cardDate.toString()
            holder.cardNumber.text = cardItem.cardNumber.toString()
        }
    }



    override fun getItemCount(): Int {
        return cardList.size
    }

    @SuppressLint("CutPasteId")
    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardName: TextView
        val cardDate: TextView
        val cardNumber: TextView

        init {
            cardName = view.findViewById(R.id.cardName)
            cardDate = view.findViewById(R.id.cardName)
            cardNumber = view.findViewById(R.id.cardName)
        }
    }
}