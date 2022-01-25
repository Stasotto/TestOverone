package com.example.testoverone.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testoverone.R
import com.example.testoverone.databinding.ActivityFilterBinding
import com.example.testoverone.presentation.listview.Adapter
import com.example.testoverone.presentation.models.DataWrapper
import com.example.testoverone.presentation.viewmodel.FilterActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilterActivity : AppCompatActivity(R.layout.activity_filter) {

    private val viewModel by viewModel<FilterActivityViewModel>()
    private val binding: ActivityFilterBinding by viewBinding()
    private val adapter by lazy { Adapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpListView()
        returnResult()
        updateListForListView()

        viewModel.dataForListView.observe(this, { listPoints ->
            adapter.setUpData(listPoints)
        })
    }

    private fun updateListForListView(){
        adapter.onChecked { id ->
            viewModel.updateData(id)

        }
    }

    private fun returnResult() {
        binding.resultButton.setOnClickListener {
            adapter.onClickLis { points ->
                viewModel.savePoint(points)
                intent.putExtra("key", DataWrapper(points))
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun setUpListView() {
        binding.listView.adapter = adapter
    }

}
