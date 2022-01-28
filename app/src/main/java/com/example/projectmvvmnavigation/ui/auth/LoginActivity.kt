package com.example.projectmvvmnavigation.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import com.example.projectmvvmnavigation.R
import com.example.projectmvvmnavigation.data.response.LoginResponse
import com.example.projectmvvmnavigation.databinding.ActivityLoginBinding
import com.example.projectmvvmnavigation.ui.home.HomeFragment
import com.example.projectmvvmnavigation.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener {
    private val authViewModel: AuthViewModel ?=null
    private var binding: ActivityLoginBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding?.authViewModel = authViewModel
        authViewModel?.authListener = this
        getUserInfo()


    }

    override fun onStarted() {
        binding?.authViewModel?.isShowProgressBar?.set(true)
    }

    override fun onSuccess(message: LiveData<LoginResponse?>) {
        message.observe(this, { loginResponse ->
            if (!loginResponse?.token.isNullOrBlank()) {
                binding?.authViewModel?.getUserInfo()
            } else {
                binding?.authViewModel?.isShowProgressBar?.set(false)
                toast("Login Fail")
            }
        })
    }

    override fun onFailure(message: String) {
        binding?.authViewModel?.isShowProgressBar?.set(false)
        toast(message)
    }

    private fun getUserInfo() {
        binding?.authViewModel?.userLiveData?.observe(this, {
            binding?.authViewModel?.isShowProgressBar?.set(false)
            it?.let {
                //TODO save data to database
                val intent = Intent(this, HomeFragment::class.java)
                startActivity(intent)
            }

        })
    }
}






