package com.anliban.copyprint.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anliban.copyprint.R
import com.anliban.copyprint.base.adapter.GeryDividerItemDecoration
import com.anliban.copyprint.databinding.ActivityMainBinding
import com.anliban.copyprint.util.deleteDialog
import com.anliban.copyprint.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainActivityViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModelProvider(viewModelFactory)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@MainActivity

        binding.recyclerView.apply {
            adapter = MainAdapter(this@MainActivity, viewModel)
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            addItemDecoration(GeryDividerItemDecoration(this@MainActivity))
        }

        viewModel.openToDeleteDialog.observe(this, Observer {
            deleteDialog {
                viewModel.delete(it)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshList()
    }

}