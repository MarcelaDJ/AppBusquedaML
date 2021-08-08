package com.example.appbusquedaml.ui.gallery

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.appbusquedaml.R
import com.example.appbusquedaml.adapter.ResponseAdapter
import com.example.appbusquedaml.databinding.FragmentGalleryBinding
import com.example.appbusquedaml.search.SearchActivity

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null
    private val TAG = GalleryFragment::class.java.simpleName
    private lateinit var responseList: RecyclerView
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root



        val myToast = Toast.makeText(context,"Gallery:",Toast.LENGTH_LONG)
        myToast.setGravity(Gravity.LEFT,200,200)
        myToast.show()
        setUpList(root)
        return root
    }

    private fun setUpList(root: View) {
        responseList = root.findViewById(R.id.result_list)

        val adapter = ResponseAdapter()
        responseList.adapter = adapter
        //adapter.submitList(ResponseRepository.getAll())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}