package com.example.projectmvvmnavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectmvvmnavigation.data.adapter.AdapterHome
import com.example.projectmvvmnavigation.data.network.APIService
import com.example.projectmvvmnavigation.data.repositories.HomeRepository
import com.example.projectmvvmnavigation.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment() : Fragment() {
    companion object {
        fun newInstance() = HomeFragment
    }

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding
    private lateinit var factory: HomeViewModelFactory
    private lateinit var viewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val api = APIService()
        val repository = HomeRepository(api)

        factory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
        viewModel.getHomes()

        viewModel.homes.observe(viewLifecycleOwner, Observer { homes ->
            recycler_view_homes.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.hasFixedSize()
                it.adapter = AdapterHome(homes)
            }
        })

    }


}