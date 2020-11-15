package kickstart2020.h

import kotlin.math.min

fun main() {
    val inputFileName = "src/kickstart2020/h/Retype.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, k, s) = readLine()!!.split(' ').map { it.toLong() }
        val res = min((k - s) * 2 + n, k + n)
        println("Case #$case: $res")
    }
}
