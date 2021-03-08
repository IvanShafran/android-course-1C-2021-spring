package me.shafran.rvsample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PersonViewHolder(
    itemView: View,
    listener: PersonAdapter.Listener?
) : ViewHolder(itemView) {
    private val personNameTextView: TextView
    private var id: Long = 0
    fun bind(person: Person) {
        personNameTextView.text = person.name
        id = person.id
    }

    init {
        personNameTextView = itemView.findViewById(R.id.personNameTextView)
        personNameTextView.setOnClickListener { listener?.onPersonClick(id) }
    }
}