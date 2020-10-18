package kickstart2020.g

import java.lang.Math.abs
import kotlin.math.min

// TODO
fun main() {
    val inputFileName = "src/kickstart2020/g/CombinationLock.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (_, n) = readLine()!!.split(' ').map { it.toInt() }
        val x = readLine()!!.split(' ').map { it.toInt() }

        val calc: (Int) -> Long = { target ->
            x.map {
                listOf(abs(it - target), abs(it + n - target), abs(it - n - target))
                    .min()?.toLong() ?: 0
            }.sum()
        }

        var l = 1
        var r = n

        while (l < r - 1) {
            val m = (l + r) / 2

            if (calc(l)  < calc(r)) {
                r = m
            } else {
                l = m
            }
        }

        println("Case #$case: ${min(calc(l), calc(r))}")
    }
}
