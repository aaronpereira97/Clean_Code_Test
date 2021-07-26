package com.ml.urbandictionaryapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ml.urbandictionaryapp.R
import com.ml.urbandictionaryapp.view.adapter.DefinitionAdapter
import com.ml.urbandictionaryapp.viewmodel.TermSearchViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DefinitionDisplayFragment : Fragment() {

    private val termSearchViewModel:TermSearchViewModel by viewModel()
    private lateinit var definitionAdapter: DefinitionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.definition_display_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
        setupObservers()
    }

    private fun initRecyclerView(view: View){
        definitionAdapter = DefinitionAdapter()

        view.findViewById<RecyclerView>(R.id.definition_display_recyclerview).apply {
            adapter = definitionAdapter
        }
    }
    private fun setupObservers(){
        termSearchViewModel.definitionSuccess.observe(viewLifecycleOwner, {
            it?.let {
                definitionAdapter.definitionList = it.terms
            }

        })

        termSearchViewModel.definitionError.observe(viewLifecycleOwner, {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
        })
    }
}