package com.gwsf.appfornstu.presentation.feature.listevent.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gwsf.appfornstu.presentation.R
import com.gwsf.domain.model.event.Event
import java.text.SimpleDateFormat

class ListEventsRecyclerAdapter(
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<ListEventsRecyclerAdapter.ListEventsHolder>() {

    private val listEvents: MutableList<Event> = mutableListOf()

    fun setListEvents(events: List<Event>) {
        listEvents.clear()
        listEvents.addAll(events)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListEventsHolder {
        val view = inflater.inflate(R.layout.fragment_list_events, parent, false)
        return ListEventsHolder(view)
    }

    override fun getItemCount(): Int {
        return listEvents.size
    }

    override fun onBindViewHolder(holder: ListEventsHolder, position: Int) {
        holder.bind(listEvents[position])
    }

    class ListEventsHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.title)
        private val date: TextView = view.findViewById(R.id.date)

        fun bind(event: Event) {
            title.text = event.name
            date.text = SimpleDateFormat.getDateInstance().format(event.calendarDataTime.time)
        }
    }

}