package com.alxminyaev.appfornstu.feature.timetable.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.alxminyaev.appfornstu.R
import com.alxminyaev.appfornstu.databinding.DayTimeTableFragmentBinding
import com.alxminyaev.appfornstu.feature.timetable.vm.DayTimeTableModelFactory
import com.alxminyaev.appfornstu.feature.timetable.vm.DayTimeTableViewModel


class DayTimeTableFragment : Fragment() {

    private lateinit var mViewModel: DayTimeTableViewModel
    private lateinit var mBinding: DayTimeTableFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.day_time_table_fragment, container, false)

        if (context != null) {
            mBinding.recyclerTimeTable.adapter = TimeTableRecyclerAdapter(context!!)
        }


        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this, DayTimeTableModelFactory()).get(DayTimeTableViewModel::class.java)
        mViewModel.loadTimeTable()
    }


}
