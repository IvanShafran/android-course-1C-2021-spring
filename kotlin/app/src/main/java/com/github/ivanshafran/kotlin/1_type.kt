package com.github.ivanshafran.kotlin

// val vs var
fun main() {
    var a: String = ""
    a = "123"

    // final
    val b: String = ""
//    b = "123"

    // Выведение типов
    val c = ""

    // nullable
    val d: String? = null
    val e: String = "123"

    // primitives
    val f: Int = 0
    // 1. Можно вызывать функции на примитивах
    // 2. Нужно явно кастить типы
    val g: Float = f.toFloat()

    // int vs Integer
    val h: Int = 0
    var i: Int? = null
    var j: List<Int>
}
