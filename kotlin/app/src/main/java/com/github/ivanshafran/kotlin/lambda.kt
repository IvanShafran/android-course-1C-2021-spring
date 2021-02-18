package com.github.ivanshafran.kotlin

fun main() {
    val x = { a: Int, b: Int -> a + b }
    repeat(10, { print("Hey") })

    repeat(10) { print("Hey") }
}

fun repeat(x: Int, action: () -> Unit) {
    for (i in 0 until x) {
        action()
    }
}
