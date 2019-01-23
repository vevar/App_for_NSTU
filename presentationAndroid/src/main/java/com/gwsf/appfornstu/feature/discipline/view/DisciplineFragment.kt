package com.gwsf.appfornstu.feature.discipline.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gwsf.appfornstu.R
import com.gwsf.appfornstu.databinding.DisciplineListFragmentBinding
import com.gwsf.appfornstu.feature.BaseFragment
import com.gwsf.appfornstu.feature.discipline.vm.DisciplineViewModel

class DisciplineFragment : BaseFragment(), DisciplineView {

    private lateinit var mViewModel: DisciplineViewModel
    private lateinit var mBinding: DisciplineListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mBinding = DataBindingUtil.inflate(inflater, R.layout.discipline_list_fragment, container, false)

        mBinding.recyclerDisciplines.adapter = DisciplineRecyclerAdapter()

        return mBinding.root
    }
}