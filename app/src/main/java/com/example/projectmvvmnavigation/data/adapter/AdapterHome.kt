package com.example.projectmvvmnavigation.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmvvmnavigation.R
import com.example.projectmvvmnavigation.data.entities.Data
import com.example.projectmvvmnavigation.databinding.ItemHomeBinding
import com.example.projectmvvmnavigation.ui.home.RecyclerViewClickListener

class AdapterHome(
    private val homes: List<Data>
) : RecyclerView.Adapter<AdapterHome.HomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_home, parent, false
            )
        )


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.itemHomeBinding.viewModel = homes[position]


    }

    override fun getItemCount() = homes.size

    inner class HomeViewHolder(
        val itemHomeBinding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(itemHomeBinding.root)

}

private val DiffCallback = object : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.id == newItem.id
    }
}