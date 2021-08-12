package com.example.appbusquedaml.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appbusquedaml.R
import com.example.appbusquedaml.model.ResultsItem
import com.squareup.picasso.Picasso


class ResponseAdapter :
    RecyclerView.Adapter<ResponseAdapter.ResponseViewHolder>() {

    var onItemClick: ((Int) -> Unit)? = null
    var responseItems: List<ResultsItem?>? = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ResponseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
        val response = responseItems?.get(position)
        holder.bind(response)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(position)
        }

    }

    class ResponseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tumbnail: ImageView = view.findViewById(R.id.img_product)
        private val title: TextView = view.findViewById(R.id.title_product)
        private val price: TextView = view.findViewById(R.id.price_product)
        private val quotes: TextView = view.findViewById(R.id.quotes_product)
        private val shipping: TextView = view.findViewById(R.id.shipping)
        private val availability: TextView = view.findViewById(R.id.availability)
        private val rate: RatingBar = view.findViewById(R.id.rating_product)
        private val rateNumber: TextView = view.findViewById(R.id.rate_number)

        fun bind(response: ResultsItem?) {

            Picasso.get().load(response?.thumbnail)
                .resize(300, 300).into(tumbnail)
            Picasso.get().isLoggingEnabled = true

            title.text = response?.title
            price.text = response?.price.toString()
            quotes.text =
                "en " + response?.installments?.quantity.toString() + "x " + response?.installments
                    ?.amount.toString()

            response?.shipping?.freeShipping.let {
                if (it == true) {
                    shipping.text = "Envio gratis"
                }
            }
            availability.text = "Disponibles " + response?.availableQuantity.toString()
            var percentaje =
                response?.seller?.sellerReputation?.transactions?.ratings?.positive?.toFloat()!!

            rate.rating = (percentaje * 5)
            rateNumber.text = response?.seller?.sellerReputation?.transactions?.total.toString()

        }
    }

    override fun getItemCount(): Int {
        return responseItems?.size!!
    }

    fun submitList(responseList: List<ResultsItem?>?) {
        responseItems = responseList
    }
}





