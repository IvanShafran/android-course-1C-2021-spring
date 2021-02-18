package com.github.ivanshafran.kotlin

fun main() {

}

// Unit ~ void
fun a(): Unit {

}

fun b(): Int {
    return 0
}

fun c(a: String = "", b: Int): String {
    return ""
}

// Extension

fun String.double(): String {
    return this + this
}

fun t() {
    val x: String = "123".double()
}

// return

fun x() = ""

// default params

fun d(x: Int = 0) {

}
