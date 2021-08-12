package com.example.appbusquedaml.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appbusquedaml.R
import com.example.appbusquedaml.adapter.ResponseAdapter
import com.example.appbusquedaml.databinding.FragmentGalleryBinding
import com.example.appbusquedaml.model.ResultsItem
import com.example.appbusquedaml.ui.slideshow.SlideshowFragment


class GalleryFragment(results: List<ResultsItem?>?) : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null
    private val TAG = GalleryFragment::class.java.simpleName
    private lateinit var responseList: RecyclerView
    private val binding get() = _binding!!
    val data = results

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setUpList(root)

        return root
    }

    private fun setUpList(root: View) {
        responseList = root.findViewById(R.id.result_list)

        val adapter = ResponseAdapter()
        responseList.adapter = adapter
        responseList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        if (data != null) {
            Log.i(TAG, "data: ${data.size}")
        }
        adapter.submitList(data)
        adapter.onItemClick = { it ->
            val myToast = Toast.makeText(context, "toca: $it", Toast.LENGTH_LONG)
            myToast.show()
            //replaceFragment(SlideshowFragment(it, data))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun replaceFragment(fragment: Fragment) {

        val slideshowFragment: SlideshowFragment? =
            requireFragmentManager().findFragmentById(com.example.appbusquedaml.R.id.nav_host_fragment_content_main) as SlideshowFragment?
        requireFragmentManager().beginTransaction()
            .replace(
                com.example.appbusquedaml.R.id.nav_host_fragment_content_main,
                fragment
            )
            .addToBackStack(null)
            .commit()
    }
}