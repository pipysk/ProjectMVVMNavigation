package com.example.projectmvvmnavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectmvvmnavigation.R
import com.example.projectmvvmnavigation.data.adapter.HomeAdapter
import com.example.projectmvvmnavigation.data.entities.Users
import com.example.projectmvvmnavigation.data.network.APIService
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment() : Fragment() {
    companion object {
        fun newInstance() = HomeFragment
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(HomeViewModel::class.java)
        fetchHome()
    }

    private fun fetchHome() {
      APIService().getAllUsers().enqueue(object :Callback<Users>{
          override fun onResponse(call: Call<Users>, response: Response<Users>) {
            val user=response.body()!!
              user?.let {
                  showHomes(listOf(it))
              }
          }

          override fun onFailure(call: Call<Users>, t: Throwable) {
              TODO("Not yet implemented")
          }

      })
    }

    private fun showHomes(data: List<Users>) {

        recyclerview_view_home.layoutManager = LinearLayoutManager(activity)
        recyclerview_view_home.hasFixedSize()
        recyclerview_view_home.adapter = HomeAdapter(data)



    }
}