package com.example.tom.daftrectask.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tom.daftrectask.Element
import com.example.tom.daftrectask.R

open class ElementAdapter(var items: List<Element>, private val onItemClicked: (Element, Int) -> Unit, private val onItemLongClicked: (Element) -> Boolean): RecyclerView.Adapter<ElementViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_recycler_view_item, parent, false)
        return ElementViewHolder(view)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) = holder.bindItem(items[position], onItemClicked, onItemLongClicked)

    override fun getItemCount() = items.size
}