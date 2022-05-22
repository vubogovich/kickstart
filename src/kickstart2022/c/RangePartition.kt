package kickstart2022.c

fun main() {
    val inputFileName = "src/kickstart2022/c/RangePartition.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, x, y) = readLine()!!.split(' ').map { it.toLong() }
        val sn = (1 + n) * n / 2

        if (sn * x % (x + y) == 0L) {
            var s = sn * x / (x + y)
            var k = n.toInt()
            val res = mutableListOf<Int>()

            while (s > 0 && k > 0) {
                if (k <= s) {
                    res.add(k)
                    s -= k
                }

                k--
            }

            println("Case #$case: POSSIBLE")
            println(res.size)
            println(res.joinToString(" "))
        } else {
            println("Case #$case: IMPOSSIBLE")
        }
    }
}
