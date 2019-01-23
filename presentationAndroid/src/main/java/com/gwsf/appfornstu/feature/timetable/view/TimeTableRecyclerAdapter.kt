package com.gwsf.appfornstu.feature.timetable.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gwsf.appfornstu.R
import com.gwsf.domain.model.discipline.Discipline
import com.gwsf.domain.model.discipline.Lesson
import com.gwsf.domain.model.timetable.Day


class TimeTableRecyclerAdapter(context: Context) :
    RecyclerView.Adapter<TimeTableRecyclerAdapter.TimeTableRecyclerHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(context)
    val listDays: MutableList<Day> = mutableListOf()

    fun setListDays(listDays: List<Day>) {
        this.listDays.clear()
        this.listDays.addAll(listDays)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeTableRecyclerHolder {
        val view = inflater.inflate(R.layout.view_day_time_table, parent, false)
        return TimeTableRecyclerHolder(view, inflater)
    }

    override fun getItemCount(): Int {
        return listDays.size
    }

    override fun onBindViewHolder(holder: TimeTableRecyclerHolder, position: Int) {
        holder.bind(listDays[position])
    }

    class TimeTableRecyclerHolder(view: View, inflater: LayoutInflater) : RecyclerView.ViewHolder(view) {
        private val textViewDate: TextView = view.findViewById(R.id.date_day)
        private val recyclerView: RecyclerView = view.findViewById(R.id.recycler_day)
        private val dayRecyclerAdapter: DayRecyclerAdapter = DayRecyclerAdapter(inflater)

        init {
            recyclerView.adapter = dayRecyclerAdapter
        }

        fun bind(day: Day) {
            //TODO format date
            textViewDate.text = day.date.toString()
            dayRecyclerAdapter.setListDisciplinesToLessons(day.listDisciplines)
        }
    }

    private class DayRecyclerAdapter(private val inflater: LayoutInflater) :
        RecyclerView.Adapter<DayRecyclerAdapter.DayRecyclerHolder>() {

        private val mListLesson: MutableList<Lesson> = mutableListOf()
        private val mMapDiscipline: MutableMap<Lesson, Discipline> = mutableMapOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayRecyclerHolder {
            val view = inflater.inflate(R.layout.view_lesson_time_table, parent, false)
            return DayRecyclerHolder(view)
        }

        override fun getItemCount(): Int {
            return mListLesson.size
        }

        override fun onBindViewHolder(holder: DayRecyclerHolder, position: Int) {
            val lesson = mListLesson[position]
            val discipline = mMapDiscipline[lesson]
            holder.bind(discipline!!.name, lesson)
        }

        fun setListDisciplinesToLessons(listLesson: List<Discipline>) {
            mListLesson.clear()

            listLesson.forEach { discipline ->
                discipline.listLessons.forEach { lesson ->
                    mMapDiscipline[lesson] = discipline
                }

                mListLesson.addAll(discipline.listLessons)
            }

            notifyDataSetChanged()
        }

        class DayRecyclerHolder(view: View) : RecyclerView.ViewHolder(view) {
            //TODO need all fields
            private val mTextViewSubjectName = view.findViewById<TextView>(R.id.discipline_name)

            fun bind(nameDiscipline: String, lesson: Lesson) {
                mTextViewSubjectName.text = nameDiscipline
            }

        }
    }
}