package com.github.ivanshafran.kotlin

fun main() {
    val a: List<String>
    val b: MutableList<String> = mutableListOf()

    val map: MutableMap<String, String> = mutableMapOf()
    val set: MutableSet<String> = mutableSetOf()

    val list = listOf(1, 2, 3)
    list.get(0)
    list[0]

    val list2 = mutableListOf<Int>()
    list2.add(1)
    list2.add(2)
    list2.add(3)
    list2[1] = 3

    val list3 = list + list2
}
