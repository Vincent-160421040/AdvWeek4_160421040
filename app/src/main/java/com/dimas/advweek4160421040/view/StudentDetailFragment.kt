package com.dimas.advweek4160421040.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dimas.advweek4160421040.R
import com.dimas.advweek4160421040.databinding.FragmentStudentDetailBinding
import com.dimas.advweek4160421040.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso

class StudentDetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var  binding:FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        viewModel.studentLD.observe(viewLifecycleOwner, { student ->
            binding.txtID.setText(student.id)
            binding.txtName.setText(student.name)
            binding.txtDoB.setText(student.dob)
            binding.txtPhone.setText(student.phone)

            student.photoUrl?.let { url ->
                Picasso.get().load(url).into(binding.imageView2)
            }

        })
    }
}