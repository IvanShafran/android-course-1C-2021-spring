package com.github.ivanshafran.kotlin

class A {
    fun loadX(): Int {
        return 0
    }

    fun saveX(a: Int) {

    }
}

class B {
    private var length: Int = 0

    fun setLength() {

    }

    fun a() {

    }
}


class C(val x: Int, y: Int)

class C2 constructor(x: Int, y: String) {

    val x: Int

    init {
        this.x = x

    }
}

// second constructor

class D {

    var y: String? = null

    constructor(x: Int, y: String) {
        this.y = y
        Singleton.staticFunction()
    }
}

object Singleton {
    val t = 0

    fun staticFunction() {
    }
}

class E {
    companion object {
        val t = 0
    }

    val b: Int = 0
}

val e = E.t
val e2 = E().b


data class Point(val x: Int, val y: Int)

fun t323() {
    val (x: Int, y: Int) = Point(0, 0)
}
