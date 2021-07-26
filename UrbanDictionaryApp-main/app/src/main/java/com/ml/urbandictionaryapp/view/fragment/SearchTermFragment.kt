package com.ml.urbandictionaryapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ml.urbandictionaryapp.R
import com.ml.urbandictionaryapp.viewmodel.TermSearchViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SearchTermFragment : Fragment() {

    private lateinit var searchTermEditText: EditText
    private lateinit var searchButton: Button

    private val termSearchViewModel:TermSearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_term_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View){
        searchTermEditText = view.findViewById(R.id.search_term_edittext)

        searchButton = view.findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener {
            searchDefinitions()
        }
    }

    private fun searchDefinitions(){
        val term =
            if(searchTermEditText.text.isNotEmpty())
                searchTermEditText.text.toString()
            else
                "Example"

        termSearchViewModel.findDefinitions(term)
    }
}