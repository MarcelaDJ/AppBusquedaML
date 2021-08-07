package com.example.appbusquedaml.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appbusquedaml.R
import com.example.appbusquedaml.model.Response

class ResponseAdapter : ListAdapter<Response, ResponseAdapter.ResponseViewHolder>(ResponseDiffCallback()) {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.product_item, parent, false)
            return ResponseViewHolder(view)
        }

        override fun onBindViewHolder(holder: ResponseViewHolder, position: Int) {
            val response = getItem(position)
            holder.bind(response)
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

            fun bind(response: Response) {
                title.text = response.results?.get(position)?.title
                price.text = response.results?.get(position)?.price.toString()
                quotes.text ="en "+ response.results?.get(position)?.installments?.quantity.toString()+"x "+ response.results?.get(position)?.installments?.amount.toString()

                response.results?.get(adapterPosition)?.shipping?.freeShipping.let {
                    if (it==true) {
                        shipping.text="Envio gratis"
                    }

                }
                availability.text="Disponibles "+response.results?.get(position)?.availableQuantity.toString()
                rate.rating = response.results?.get(position)?.seller?.sellerReputation?.transactions?.ratings?.positive?.toFloat()!!
                rateNumber.text = response.results?.get(position)?.seller?.sellerReputation?.transactions?.total.toString()
            }
        }
    }

   class ResponseDiffCallback : DiffUtil.ItemCallback<Response>() {
        override fun areItemsTheSame(oldItem: Response, newItem: Response): Boolean {
            return oldItem.results?.get(0)?.title == newItem.results?.get(0)?.title
        }
        override fun areContentsTheSame(oldItem: Response, newItem: Response): Boolean {
            return oldItem == newItem
        }
    }


