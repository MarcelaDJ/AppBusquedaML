package com.example.appbusquedaml

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appbusquedaml.databinding.ActivityMainBinding
import com.example.appbusquedaml.manager.ApiClient
import com.example.appbusquedaml.manager.ApiService
import com.example.appbusquedaml.model.Response
import com.example.appbusquedaml.ui.gallery.GalleryFragment
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        handleIntent(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.main, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            //  setSearchableInfo(searchManager.getSearchableInfo(ComponentName(this@MainActivity,SearchActivity::class.java)))
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            isIconifiedByDefault = false

        }

        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            Log.i(TAG, "Buscaste: $query")
            query?.let { searchBy(it) }
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment_content_main, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun searchBy(query: String) {

        Log.i(TAG, "entra a buscar $query")
        val apiService: ApiService = ApiClient.getRetrofit().create(ApiService::class.java)
        val result: Call<Response> = apiService.getItemsBySearch(query)
        // val result: Call<Response> = apiService.getItemsBySearch()

        result.enqueue(object : Callback<Response> {

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val items = response.body()
                Log.i(TAG, "objeto:" + Gson().toJson(items?.paging?.total))

                if (items?.paging?.total!! >= 0) {

                    replaceFragment(GalleryFragment(items.results))
                } else {
                    val myToast =
                        Toast.makeText(applicationContext, "Sin Resultados", Toast.LENGTH_LONG)
                    myToast.show()
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.i(TAG, "t: $t")
                val myToast =
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG)
                myToast.show()
            }
        })
    }
}
