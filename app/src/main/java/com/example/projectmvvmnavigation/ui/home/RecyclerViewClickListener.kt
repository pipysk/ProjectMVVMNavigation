package com.example.projectmvvmnavigation.ui.home

import android.view.View
import com.example.projectmvvmnavigation.data.entities.Data

interface RecyclerViewClickListener {
fun onRecyclerViewItemClick(view: View, home:Data)
}