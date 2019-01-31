package com.gwsf.appfornstu.presentation.feature.listevent.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gwsf.appfornstu.presentation.App
import com.gwsf.appfornstu.presentation.R
import com.gwsf.appfornstu.presentation.databinding.FragmentListEventsBinding
import com.gwsf.appfornstu.presentation.feature.BaseFragment
import com.gwsf.appfornstu.presentation.feature.listevent.vm.ListEvenViewModel
import com.gwsf.appfornstu.presentation.feature.listevent.vm.ListEventViewModelFactory
import com.gwsf.appfornstu.presentation.internal.di.component.listevents.DaggerListEventsScreenComponent
import com.gwsf.domain.model.event.Event
import javax.inject.Inject

class ListEventFragment : BaseFragment(), ListEventView {

    @Inject
    lateinit var mListEventViewModelFactory: ListEventViewModelFactory

    private lateinit var mBinding: FragmentListEventsBinding

    private lateinit var mViewModel: ListEvenViewModel

    private lateinit var mEventsRecyclerAdapter: ListEventsRecyclerAdapter
    private val mListEventsObserver = Observer<List<Event>> {
        mEventsRecyclerAdapter.setListEvents(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = App.getApp(this.requireContext())

        DaggerListEventsScreenComponent.builder()
            .appComponent(app.getApplicationComponent())
            .listEventsComponent(app.getListEventsComponent())
            .build()
            .inject(this)

        mViewModel = ViewModelProviders.of(this, mListEventViewModelFactory)
            .get(ListEvenViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_list_events, container, false)

        mEventsRecyclerAdapter = ListEventsRecyclerAdapter(inflater)
        mBinding.recyclerView.adapter = mEventsRecyclerAdapter
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        return mBinding.root
    }

    override fun showProgressBar() {
        mBinding.progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        mBinding.progressBar.visibility = ProgressBar.GONE
        mBinding.recyclerView.visibility = RecyclerView.VISIBLE
    }

    override fun onStart() {
        super.onStart()

        mViewModel.loadListEvents()
    }

    override fun onResume() {
        super.onResume()

        mViewModel.mListEvents.observe(this, mListEventsObserver)
    }

    override fun onPause() {
        super.onPause()

        mViewModel.mListEvents.removeObserver(mListEventsObserver)
    }
}