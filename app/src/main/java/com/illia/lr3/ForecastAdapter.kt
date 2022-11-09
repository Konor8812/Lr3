package com.illia.lr3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.illia.lr3.databinding.RecycleRowBinding


class ForecastAdapter(
    private val entityList: List<Forecast>,
    private val onItemClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<ForecastAdapter.ForecastHolder>() {

    class ForecastHolder(
        private val itemBinding: RecycleRowBinding,
        private val onItemClick: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(content: String, url: String?) {

            Glide.with(itemView)
                .load(url)
                .centerCrop()
                .placeholder(itemBinding.imagePlaceholder.drawable)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(itemBinding.imagePlaceholder)


            itemBinding.forecastDesc.setText(content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastHolder {
        val itemBinding = RecycleRowBinding.inflate(LayoutInflater.from(parent.context))
        return ForecastHolder(itemBinding, onItemClick)
    }

    override fun onBindViewHolder(holder: ForecastHolder, position: Int) {
        val forecast = entityList[position]

        holder.bind(forecast.forecastAsString, forecast.imageUrl)
    }

    override fun getItemCount(): Int {
        return entityList.size
    }
}