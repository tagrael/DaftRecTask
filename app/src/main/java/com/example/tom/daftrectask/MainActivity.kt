package com.example.tom.daftrectask

import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.tom.daftrectask.recycler.ElementAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ElementViewModel
    private lateinit var elementAdapter: ElementAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ElementViewModel::class.java)
        viewModel.getElements().observe(this, Observer(this::updateElementList))

        elementRecyclerView.layoutManager = LinearLayoutManager(this)
        elementAdapter = ElementAdapter(emptyList(), this::onClickListener, this::onLongClickListener)
        elementRecyclerView.adapter = elementAdapter
    }

    private fun onClickListener(element: Element, position: Int) {
        viewModel.addPreviousElement(element, position)
        elementAdapter.notifyDataSetChanged()
    }

    private fun onLongClickListener(element: Element): Boolean {
        viewModel.zeroElement(element)
        elementAdapter.notifyDataSetChanged()
        return true
    }

    private fun updateElementList(elementList: List<Element>?) {
        if (elementList == null) return
        elementAdapter.items = elementList
        elementAdapter.notifyDataSetChanged()
    }
}
