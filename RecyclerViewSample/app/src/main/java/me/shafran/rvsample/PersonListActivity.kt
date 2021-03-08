package me.shafran.rvsample

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PersonListActivity : AppCompatActivity(), PersonAdapter.Listener {

    override fun onPersonClick(id: Long) {
        startActivity(PersonDetailActivity.getIntent(this, id))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)
        val recyclerView = findViewById<RecyclerView>(R.id.personRecyclerView)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        } else {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
        recyclerView.setHasFixedSize(true)
        recyclerView.recycledViewPool.setMaxRecycledViews(0, 5)
        val adapter = PersonAdapter()
        recyclerView.adapter = adapter
        adapter.setPersonList(PersonRepository.personList)
        adapter.setListener(this)
    }
}
