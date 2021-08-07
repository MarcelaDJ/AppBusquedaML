package com.example.appbusquedaml.search

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast

class SearchActivity : Activity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            handleIntent(intent)
        }

        override fun onNewIntent(intent: Intent) {

            handleIntent(intent)
        }

        private fun handleIntent(intent: Intent) {

            if (Intent.ACTION_SEARCH == intent.action) {
                val query = intent.getStringExtra(SearchManager.QUERY)
                val myToast = Toast.makeText(applicationContext,"Buscaste: $query",Toast.LENGTH_LONG)
                myToast.setGravity(Gravity.LEFT,200,200)
                myToast.show()
            }
        }
}