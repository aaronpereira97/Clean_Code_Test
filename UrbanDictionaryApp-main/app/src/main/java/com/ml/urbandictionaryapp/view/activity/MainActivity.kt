package com.ml.urbandictionaryapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ml.urbandictionaryapp.R
import com.ml.urbandictionaryapp.view.fragment.DefinitionDisplayFragment
import com.ml.urbandictionaryapp.view.fragment.SearchTermFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragments()
    }

    private fun loadFragments(){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.search_frame, SearchTermFragment())
            .add(R.id.display_frame, DefinitionDisplayFragment())
            .commit()
    }
}