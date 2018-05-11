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

    fun addPreviousElement(element: Element) { //increases the value of the element passed as the parameter by the value of the previous element in the list
        val index = elementLiveData.value?.indexOf(element)
        if (index != null) {
            if (index == 0) {
                element.value += elementLiveData.value?.last()?.value ?: 0
            }
            else  {
                element.value += elementLiveData.value?.get(index - 1)?.value ?: 0
            }
        }
    }

}