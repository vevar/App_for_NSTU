package com.gwsf.appfornstu.presentation.feature.discipline.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gwsf.appfornstu.presentation.R
import com.gwsf.domain.model.discipline.Discipline

class DisciplineRecyclerAdapter(
    context: Context,
    private val selectDisciplineListener: SelectDisciplineListener
) : RecyclerView.Adapter<DisciplineRecyclerAdapter.DisciplineHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val listDiscipline: MutableList<Discipline> = mutableListOf()

    fun setListDiscipline(listDiscipline: List<Discipline>) {
        this.listDiscipline.clear()
        this.listDiscipline.addAll(listDiscipline)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplineHolder {
        val view = inflater.inflate(R.layout.view_discipline, parent, false)
        return DisciplineHolder(view, selectDisciplineListener)
    }

    override fun getItemCount(): Int {
        return listDiscipline.size
    }

    override fun onBindViewHolder(holder: DisciplineHolder, position: Int) {
        holder.bind(listDiscipline[position])
    }

    class DisciplineHolder(view: View, private val selectDisciplineListener: SelectDisciplineListener) :
        RecyclerView.ViewHolder(view) {

        private val disciplineName: TextView = view.findViewById(R.id.discipline_name)
        private val professor: TextView = view.findViewById(R.id.professor_name)

        fun bind(discipline: Discipline) {
            disciplineName.text = discipline.name
            val majorProfessor = discipline.majorProfessor
            professor.text = "${majorProfessor.secondName} ${majorProfessor.firstName} ${majorProfessor.middleName}"

            itemView.setOnClickListener {
                selectDisciplineListener.OnDisciplineSelected(discipline)
            }
        }
    }

    interface SelectDisciplineListener {
        fun OnDisciplineSelected(discipline: Discipline)
    }
}
