package com.ml.urbandictionaryapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ml.urbandictionaryapp.R
import com.ml.urbandictionaryapp.databinding.DefinitionRowItemBinding
import com.ml.urbandictionaryapp.model.Term
import com.ml.urbandictionaryapp.model.TermResponse
import com.ml.urbandictionaryapp.view.adapter.DefinitionAdapter.*
import java.util.zip.Inflater

class DefinitionAdapter : RecyclerView.Adapter<DefinitionViewHolder>(){

    var definitionList:List<Term> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionViewHolder {
        val view = DefinitionRowItemBinding.inflate(
            LayoutInflater.from(parent.context),parent, false
        )
        return DefinitionViewHolder(view)
    }

    override fun onBindViewHolder(holder: DefinitionViewHolder, position: Int) {
        holder.binding.also {
            it.definition = definitionList[position]
        }
    }

    override fun getItemCount(): Int {
        return definitionList.size
    }

    class DefinitionViewHolder(val binding: DefinitionRowItemBinding) :
        RecyclerView.ViewHolder(binding.root){
    }

}