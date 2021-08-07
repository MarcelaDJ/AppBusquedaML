package com.example.appbusquedaml.search

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.example.appbusquedaml.model.Response
import com.google.gson.Gson

class SearchActivity : Activity() {

    private val TAG = SearchActivity::class.java.simpleName

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
                Log.i(TAG,"Buscaste: $query")
                /*val myToast = Toast.makeText(applicationContext,"Buscaste: $query",Toast.LENGTH_LONG)
                myToast.setGravity(Gravity.LEFT,200,200)
                myToast.show()*/

               /* Gson gson = new Gson()
                gson.fromJson(response, Response)
                Log.i(TAG,data.toString())*/
            }
        }
}