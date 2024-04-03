package com.dimas.advweek4160421040.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.dimas.advweek4160421040.databinding.LaptopListItemBinding
import com.dimas.advweek4160421040.model.Laptop

class LaptopListAdapter(val laptopList:ArrayList<Laptop>):RecyclerView.Adapter<LaptopListAdapter.LaptopViewHolder>() {
    class LaptopViewHolder(var binding: LaptopListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopViewHolder {
        val binding = LaptopListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaptopViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return laptopList.size
    }

    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) {
        holder.binding.txtID.text = laptopList[position].id.toString()
        holder.binding.txtName.text = laptopList[position].brand

//        holder.binding.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudentDetail()
//            Navigation.findNavController(it).navigate(action)
//        }
    }

    fun updateLaptopList(newLaptopList: ArrayList<Laptop>) {
        laptopList.clear()
        laptopList.addAll(newLaptopList)
        notifyDataSetChanged()
    }
}
