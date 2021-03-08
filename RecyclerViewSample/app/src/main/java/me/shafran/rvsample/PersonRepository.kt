package me.shafran.rvsample

import android.content.Context
import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object PersonRepository {
    private val PERSON_LIST: MutableMap<Long, Person> = mutableMapOf()

    val personList: List<Person>
        get() = PERSON_LIST.values.toList()

    fun initialize(context: Context) {
        try {
            BufferedReader(InputStreamReader(context.assets.open("names.txt")))
                .use { reader ->
                    var name = reader.readLine()
                    var id: Long = 0
                    while (!TextUtils.isEmpty(name)) {
                        PERSON_LIST[id] = Person(id, name)
                        ++id
                        name = reader.readLine()
                    }
                }
        } catch (e: IOException) {
            // Ничего не делать
        }
    }

    fun getPersonById(id: Long): Person? {
        return PERSON_LIST[id]
    }
}