package com.example.testoverone.presentation.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.testoverone.databinding.ItemViewBinding
import com.example.testoverone.presentation.models.Point

class Adapter : BaseAdapter(), View.OnClickListener {

    private val resultList = mutableListOf<Point>()
    private var dataList: List<Point> = mutableListOf()

    private var listenerItem: ((List<Point>) -> Unit)? = null
    private var onCheckedListener: ((Int) -> Unit)? = null


    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(p0: Int): Point {
        return dataList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return dataList[p0].id.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var points = getItem(p0)
        points = points.copy(id = p0)

        val binding = p1?.tag as ItemViewBinding? ?: createBinding(p2)


        with(binding) {
            latitude.text = points.lat.toString()
            longitude.text = points.lan.toString()
            checkbox.isChecked = points.isChecked
            checkbox.tag = points
        }

        return binding.root
    }

    override fun onClick(v: View?) {
        val point = v?.tag as Point
        resultList.add(point)
        onCheckedListener?.invoke(point.id)
    }

    fun onClickLis(listener: (List<Point>) -> Unit) {
        listenerItem = listener
        listenerItem?.invoke(resultList)
    }

    fun onChecked(listener: (Int) -> Unit) {
        onCheckedListener = listener
    }

    fun setUpData(list: List<Point>) {
        dataList = list
        notifyDataSetChanged()
    }


    private fun createBinding(parent: ViewGroup?): ItemViewBinding {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent?.context))
        binding.checkbox.setOnClickListener(this)
        binding.root.tag = binding
        return binding
    }

}