package com.example.appbusquedaml.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.appbusquedaml.R

class SearchActivity : AppCompatActivity() {

    private val TAG = SearchActivity::class.java.simpleName

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            handleIntent(intent)
        }

        override fun onNewIntent(intent: Intent) {
            super.onNewIntent(intent)

            handleIntent(intent)
        }

        private fun handleIntent(intent: Intent) {

            if (Intent.ACTION_SEARCH == intent.action) {
                val query = intent.getStringExtra(SearchManager.QUERY)
                Log.i(TAG,"Buscaste: $query")
                val myToast = Toast.makeText(applicationContext,"Buscaste: $query",Toast.LENGTH_LONG)
                myToast.setGravity(Gravity.LEFT,200,200)
                myToast.show()

               /* Gson gson = new Gson()
                gson.fromJson(response, Response)
                Log.i(TAG,data.toString())*/
            }
        }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}