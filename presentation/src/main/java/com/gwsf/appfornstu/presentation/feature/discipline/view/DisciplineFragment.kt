package com.gwsf.appfornstu.presentation.feature.discipline.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gwsf.appfornstu.presentation.App
import com.gwsf.appfornstu.presentation.R
import com.gwsf.appfornstu.presentation.databinding.DisciplineListFragmentBinding
import com.gwsf.appfornstu.presentation.feature.BaseFragment
import com.gwsf.appfornstu.presentation.feature.discipline.vm.DisciplineViewModel
import com.gwsf.appfornstu.presentation.feature.discipline.vm.DisciplineViewModelFactory
import com.gwsf.domain.model.discipline.Discipline
import javax.inject.Inject

class DisciplineFragment : BaseFragment(), DisciplineView {

    @Inject
    lateinit var mDisciplineViewModelFactory: DisciplineViewModelFactory

    private lateinit var mViewModel: DisciplineViewModel
    private lateinit var mBinding: DisciplineListFragmentBinding

    private lateinit var mDisciplineAdapter: DisciplineRecyclerAdapter

    private val mListDisciplineObserver = Observer<List<Discipline>> {
        mDisciplineAdapter.setListDiscipline(it)
        hideProgressBar()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        App.getApp(this.requireContext())
            .getScreenComponent()
            .inject(this)

        mViewModel = ViewModelProviders.of(this, mDisciplineViewModelFactory)
            .get(DisciplineViewModel::class.java)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mBinding = DataBindingUtil
            .inflate(inflater, R.layout.discipline_list_fragment, container, false)

        mDisciplineAdapter = DisciplineRecyclerAdapter(
            this.context!!,
            object : DisciplineRecyclerAdapter.SelectDisciplineListener {
                override fun OnDisciplineSelected(discipline: Discipline) {
                    //TODO Here star activity
                }

            })

        mBinding.recyclerDisciplines.adapter = mDisciplineAdapter
        mBinding.recyclerDisciplines.layoutManager = LinearLayoutManager(this.context)

        initSearchField()


        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        showProgressBar()
        mViewModel.loadListDisciplines()
    }

    override fun onResume() {
        super.onResume()

        mViewModel.mVisibleListDiscipline.observe(this, mListDisciplineObserver)
    }

    override fun onPause() {
        super.onPause()

        mViewModel.mVisibleListDiscipline.removeObserver(mListDisciplineObserver)
    }

    override fun showProgressBar() {
        mBinding.recyclerDisciplines.visibility = RecyclerView.GONE
        mBinding.progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        mBinding.progressBar.visibility = ProgressBar.GONE
        mBinding.recyclerDisciplines.visibility = RecyclerView.VISIBLE
    }

    private fun initSearchField() {
        mBinding.searchEditText.setOnFocusChangeListener { v, hasFocus ->
            val editText = v as EditText
            if (hasFocus) {
                editText.hint = ""
            } else {
                editText.hint = this.resources.getString(R.string.search_discipline)
            }
        }

        mBinding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                mViewModel.mSearchedDiscipline.value = s.toString()
            }
        })
    }
}