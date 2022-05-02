package com.example.idus.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.idus.MyApplication
import com.example.idus.R
import com.example.idus.adapter.MainAdapter
import com.example.idus.databinding.ActivityMainBinding
import com.example.idus.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initData()
        initViews()
        initObservers()
    }

    private fun initData() {
        lifecycleScope.launch {
            viewModel.getLocationData()
        }
    }

    private fun initViews() {
        adapter = MainAdapter()
        binding.rvMain.adapter = adapter

        binding.refreshLayout.setOnRefreshListener {
            initData()

            binding.refreshLayout.isRefreshing = false
        }
    }

    private fun initObservers() {
        viewModel.locationData.observe(this) {
            if (it.isEmpty()) {
                binding.progressBar.visibility = View.VISIBLE
                binding.rvMain.visibility = View.GONE
            } else {
                adapter.setList(it)
                binding.progressBar.visibility = View.GONE
                binding.rvMain.visibility = View.VISIBLE
            }
        }
    }

}