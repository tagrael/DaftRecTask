package com.example.tom.daftrectask.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.element_recycler_view_item.view.*
import com.example.tom.daftrectask.Element
import com.example.tom.daftrectask.R


class ElementViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val valueView = itemView.valueView
    private val colorView = itemView.colorView

    fun bindItem(element: Element, onItemClicked: (Element, Int) -> Unit, onItemLongClicked: (Element) -> Boolean) {

        if (element.color == Element.Color.BLUE) {
            valueView.text = (element.value).toString()
            colorView.setImageResource(R.drawable.blue_button)
        }

        else {
            valueView.text = (3 * element.value).toString()
            colorView.setImageResource(R.drawable.red_button)
        }

        itemView.setOnClickListener { onItemClicked(element, this.layoutPosition) }
        itemView.setOnLongClickListener { onItemLongClicked(element) }
    }

}