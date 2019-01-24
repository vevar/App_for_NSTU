package com.gwsf.appfornstu.feature.discipline.view

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
import com.gwsf.appfornstu.R
import com.gwsf.appfornstu.databinding.DisciplineListFragmentBinding
import com.gwsf.appfornstu.feature.BaseFragment
import com.gwsf.appfornstu.feature.discipline.vm.DisciplineViewModel
import com.gwsf.appfornstu.feature.discipline.vm.DisciplineViewModelFactory
import com.gwsf.domain.model.discipline.Discipline

class DisciplineFragment : BaseFragment(), DisciplineView {


    private lateinit var mViewModel: DisciplineViewModel
    private lateinit var mBinding: DisciplineListFragmentBinding

    private lateinit var mDisciplineAdapter: DisciplineRecyclerAdapter


    private val mListDisciplineObserver = Observer<List<Discipline>> {
        mDisciplineAdapter.setListDiscipline(it)
        hideProgressBar()
    }

    override fun showProgressBar() {
        mBinding.recyclerDisciplines.visibility = RecyclerView.GONE
        mBinding.progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        mBinding.progressBar.visibility = ProgressBar.GONE
        mBinding.recyclerDisciplines.visibility = RecyclerView.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProviders.of(this,DisciplineViewModelFactory(0)).get(DisciplineViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mBinding = DataBindingUtil.inflate(inflater, R.layout.discipline_list_fragment, container, false)

        mDisciplineAdapter = DisciplineRecyclerAdapter(this.context!!)
        mBinding.recyclerDisciplines.adapter = mDisciplineAdapter
        mBinding.recyclerDisciplines.layoutManager = LinearLayoutManager(this.context)

        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        showProgressBar()
        mViewModel.loadListDisciplines()
    }

    override fun onResume() {
        super.onResume()

        mViewModel.listDiscipline.observe(this, mListDisciplineObserver)
    }

    override fun onPause() {
        super.onPause()

        mViewModel.listDiscipline.removeObserver(mListDisciplineObserver)
    }
}