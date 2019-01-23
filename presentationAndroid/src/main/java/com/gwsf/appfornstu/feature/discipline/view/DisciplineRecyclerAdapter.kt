package com.gwsf.appfornstu.feature.discipline.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gwsf.appfornstu.R
import com.gwsf.domain.model.discipline.Discipline

class DisciplineRecyclerAdapter(context: Context) : RecyclerView.Adapter<DisciplineRecyclerAdapter.DisciplineHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val listDiscipline: MutableList<Discipline> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplineHolder {
        val view = inflater.inflate(R.layout.discipline_list_fragment, parent, false)
        return DisciplineHolder(view)
    }

    override fun getItemCount(): Int {
        return listDiscipline.size
    }

    override fun onBindViewHolder(holder: DisciplineHolder, position: Int) {
        holder.bind(listDiscipline[position])
    }

    class DisciplineHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val disciplineName: TextView = view.findViewById(R.id.discipline_name)

        fun bind(discipline: Discipline) {
            disciplineName.text = discipline.name
        }
    }
}
