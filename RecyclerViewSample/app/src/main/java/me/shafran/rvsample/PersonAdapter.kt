package me.shafran.rvsample

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {
    interface Listener {
        fun onPersonClick(id: Long)
    }

    private var personList: List<Person> = emptyList()
    private var listener: Listener? = null

    fun setListener(listener: Listener?) {
        this.listener = listener
    }

    fun setPersonList(personList: List<Person>) {
        this.personList = personList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(
            R.layout.person_list_item,
            parent,
            false
        )
        Log.d("PersonAdapter", "onCreateViewHolder")
        return PersonViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personList[position])
        Log.d("PersonAdapter", "onBindViewHolder")
    }

    override fun getItemCount() = personList.size
}
