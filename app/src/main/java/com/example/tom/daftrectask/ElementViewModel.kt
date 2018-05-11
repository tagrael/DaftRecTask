package com.example.tom.daftrectask

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class ElementViewModel: ViewModel() {

    private val elementLiveData = MutableLiveData<MutableList<Element>>()
    private val elementDataSource = ElementDataSource()

    init {
        elementDataSource.populateElements(10)
        elementLiveData.value = elementDataSource.getElements()
    }

    fun getElements() = elementLiveData

    fun zeroElement(element: Element) {
        element.value = 0
    }

    fun addPreviousElement(element: Element, position: Int) {
            if (position == 0) {
                element.value += elementLiveData.value?.last()?.value ?: 0
            }
            else  {
                element.value += elementLiveData.value?.get(position - 1)?.value ?: 0
            }

    }

}