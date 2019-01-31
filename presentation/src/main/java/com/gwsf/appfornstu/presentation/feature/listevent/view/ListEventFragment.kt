package com.gwsf.appfornstu.presentation.feature.listevent.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.gwsf.appfornstu.presentation.App
import com.gwsf.appfornstu.presentation.R
import com.gwsf.appfornstu.presentation.databinding.FragmentListEventsBinding
import com.gwsf.appfornstu.presentation.feature.BaseFragment
import com.gwsf.appfornstu.presentation.feature.listevent.vm.ListEvenViewModel
import com.gwsf.appfornstu.presentation.feature.listevent.vm.ListEventViewModelFactory
import com.gwsf.appfornstu.presentation.internal.di.component.listevents.DaggerListEventsScreenComponent
import javax.inject.Inject

class ListEventFragment : BaseFragment() {

    @Inject
    lateinit var mListEventViewModelFactory: ListEventViewModelFactory

    private lateinit var mBinding: FragmentListEventsBinding

    private lateinit var mViewModel: ListEvenViewModel

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

        return mBinding.root
    }

}