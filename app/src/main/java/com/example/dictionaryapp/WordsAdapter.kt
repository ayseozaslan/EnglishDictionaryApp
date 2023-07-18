package com.example.dictionaryapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class WordsAdapter(var mContext:Context,var wordslist:List<Words>)
    :RecyclerView.Adapter<WordsAdapter.CardHolder>(){


    inner class CardHolder(view:View):RecyclerView.ViewHolder(view){

              var wordDesign:CardView
              var textviewEnglish:TextView
              var textviewTurkısh:TextView

              init{
                  wordDesign=view.findViewById(R.id.wordDesign)
                  textviewEnglish=view.findViewById(R.id.textViewEnglish)
                  textviewTurkısh=view.findViewById(R.id.textViewTurkısh)
              }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val design=LayoutInflater.from(mContext).inflate(R.layout.card_design,parent,false)
        return CardHolder(design)
    }

    override fun getItemCount(): Int {
         return wordslist.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        var word=wordslist.get(position)
        holder.textviewEnglish.text=word.englısh
        holder.textviewTurkısh.text=word.turkısh

        holder.wordDesign.setOnClickListener {
            val intent=Intent(mContext,DetailActivity::class.java)
            intent.putExtra("article",word)
            mContext.startActivity(intent)


        }

    }












}