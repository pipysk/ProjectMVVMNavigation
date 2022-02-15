package com.example.projectmvvmnavigation.data.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmvvmnavigation.R
import com.example.projectmvvmnavigation.data.entities.Users
import com.example.projectmvvmnavigation.ui.dashboard.DashboardFragment
import com.squareup.picasso.Picasso

class HomeAdapter(
    val data: List<Users?>
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

            Picasso.get().load(data[0]!!.data[position].avatar).into(holder.img_logo)
            holder.tv_Name.text = data[0]!!.data[position].first_name
            holder.tv_Email.text = data[0]!!.data[position].email

        holder.itemView.setOnClickListener(View.OnClickListener {


        })

    }

    override fun getItemCount(): Int {
        return data[0]!!.data.size
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img_logo: ImageView = itemView.findViewById(R.id.img_logo)
        val tv_Name: TextView = itemView.findViewById(R.id.tv_Name)
        val tv_Email: TextView = itemView.findViewById(R.id.tv_Email)

    }
}
