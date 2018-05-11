package com.example.tom.daftrectask

import android.util.Log
import java.util.*

class ElementDataSource {
    private val elements = mutableListOf<Element>()
    private val observer: Observer? = null

    fun getElements() = elements

    fun populateElements(amount: Int) {
        val random = Random()

        for (i in 0..(amount - 1)) {
            elements.add(i, Element(random.nextInt(10), Element.Color.values()[random.nextInt(2)]))
        }

        observer?.onChanged(this)
    }

    interface Observer {
        fun onChanged(elementDataSource: ElementDataSource)
    }

}