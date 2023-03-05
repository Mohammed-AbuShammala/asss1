package com.example.myapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myapplication.databinding.CardItemBinding

class Adapter(var activity: Activity, var data: ArrayList<UserData>) : BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return data[p0].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent!!.context), parent, false)
        val  rout=convertView
        if (rout==null){
           binding.name1.text=data[position].name.toString()
            binding.phone1.text=data[position].phoneNumber
            binding.address1.text=data[position].address

        }
        return  binding.root

    }
}