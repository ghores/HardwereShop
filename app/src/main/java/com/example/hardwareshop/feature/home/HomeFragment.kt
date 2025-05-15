package com.example.hardwareshop.feature.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.hardwareshop.R
import com.example.hardwareshop.base.BaseFragment
import timber.log.Timber

class HomeFragment : BaseFragment() {
    val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.bannersLiveData.observe(viewLifecycleOwner) {
            Log.i("HOME", it.toString())
            Timber.i(it.toString())
        }
    }
}