package com.example.appbusquedaml.ui.slideshow

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appbusquedaml.R
import com.example.appbusquedaml.adapter.ResponseAdapter
import com.example.appbusquedaml.databinding.FragmentSlideshowBinding
import com.example.appbusquedaml.model.ResultsItem
import com.squareup.picasso.Picasso

class SlideshowFragment(pos: Int, data: List<ResultsItem?>?) : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel
    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var indexR = pos
    var dataR = data

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        Log.i(TAG, "pos: $indexR")

        showDetails(root)
        return root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showDetails(root: View) {

        val tumbnail: ImageView = root.findViewById(R.id.detail_img_product)
        val title: TextView = root.findViewById(R.id.detail_title)
        val price: TextView = root.findViewById(R.id.detail_price)
        val rate: RatingBar = root.findViewById(R.id.detail_rating)
        val rateNumber: TextView = root.findViewById(R.id.detail_rate_number)

        Picasso.get().load(dataR?.get(indexR)?.thumbnail)
            .resize(300, 300).into(tumbnail)
        Picasso.get().isLoggingEnabled = true

        title.text = dataR?.get(indexR)?.title
        price.text = "$" + dataR?.get(indexR)?.price.toString()
        var percentaje =
            dataR?.get(indexR)?.seller?.sellerReputation?.transactions?.ratings?.positive?.toFloat()!!
        rate.rating = (percentaje * 5)
        rateNumber.text =
            dataR?.get(indexR)?.seller?.sellerReputation?.transactions?.total.toString()
    }

}