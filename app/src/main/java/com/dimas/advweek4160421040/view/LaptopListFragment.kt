package com.dimas.advweek4160421040.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimas.advweek4160421040.R
import com.dimas.advweek4160421040.databinding.FragmentLaptopListBinding
import com.dimas.advweek4160421040.viewmodel.LaptopListViewModel

class LaptopListFragment : Fragment() {
    private lateinit var binding:FragmentLaptopListBinding
    private lateinit var viewModel: LaptopListViewModel
    private val laptopListAdapter = LaptopListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaptopListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(LaptopListViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = laptopListAdapter


    }

    fun observerViewModel() {
        viewModel.laptopLD.observe(viewLifecycleOwner, Observer {
            laptopListAdapter.updateLaptopList(it)
        })

        viewModel.laptopLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true){
                binding.txtError.visibility = View.VISIBLE

            }else{
                binding.txtError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true){
                binding.progressLoad.visibility = View.VISIBLE
                binding.recView.visibility = View.GONE
            }else{
                binding.progressLoad.visibility = View.GONE
                binding.recView.visibility = View.VISIBLE
            }
        })
    }
}