package kickstart2020.h

import kotlin.math.max

private val power5 = Array(20) { 1L }

fun main() {
    val inputFileName = "src/kickstart2020/h/BoringNumbers.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (i in 1 until power5.size) power5[i] = power5[i - 1] * 5

    for (case in 1..readLine()!!.toInt()) {
        val (l, r) = readLine()!!.split(' ').map { it.toLong() }
        val res = boring(r) - boring(l - 1)
        println("Case #$case: $res")
    }
}

private fun boring(k: Long): Long {
    val s = k.toString()
    return calculate(s) + (1 until s.length).map { power5[it] }.sum()
}

private fun calculate(s: String): Long {
    return when (s.length) {
        1 -> (s.toLong() + 1) / 2
        2 -> s.toLong() / 20 * 5 + if (s[0].toInt() % 2 > 0) (s.substring(1).toLong()) / 2 + 1 else 0
        else -> max(0, s.take(2).toInt() - 1).toString().let { if (it.length == 2) calculate(it) * power5[s.length - 2] else 0 } +
            if (s[0].toInt() % 2 > 0 && s[1].toInt() % 2 == 0) calculate(s.substring(2)) else 0
    }
}
