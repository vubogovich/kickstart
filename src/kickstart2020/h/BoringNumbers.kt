package kickstart2020.h

fun main() {
    val inputFileName = "src/kickstart2020/h/BoringNumbers.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (l, r) = readLine()!!.split(' ').map { it.toLong() }
        val res = boring(r) - boring(l - 1)
        println("Case #$case: $res")
    }

    // TODO solve case with leading zeros
    var r2 = 0L
    for (i in 1..1000000) {
        val r1 = boring(i.toLong())

        if (i.toString().mapIndexed { index, ch -> index % 2 != ch.toInt() % 2 }.all { it }) {
            r2++
        }

        if (r1 != r2) {
            println("$i $r1 <> $r2")
            break
        }
    }
}

private fun boring(k: Long, a: Int = 5): Long {
    var l = 0
    var m = 1L

    while (k / m >= 100) {
        l++
        m *= 10
    }

    val na = if (l > 0) 0 else 5

    return when {
        k < 10 && a > 0 -> (k + 1) / 2
        k < 100 && k / 10 % 2 == 0L -> (k / 20) * 5 + a
        k < 100 -> (k / 20) * 5 + (k % 10) / 2 + a + 1
        k / m / 10 % 2 == 1L && k / m % 2 == 0L -> boring(k / m - 1, 0) * boring(m - 1, na) + boring(m * 10 - 1) + boring(k % m, na)
        else -> boring(k / m - 1, 0) * boring(m - 1, na) + boring(m * 10 - 1)
    }
}
