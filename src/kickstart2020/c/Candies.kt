package kickstart2020.c

// TODO check solution
fun main() {
    val inputFileName = "src/kickstart2020/c/Candies.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (_, q) = readLine()!!.split(' ').map { it.toInt() }
        val a = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

        val divider = Math.min(a.size, 330)

        val calcSection: (Int) -> Pair<Long, Long> = { section ->
            var sum1 = 0L
            var sum2 = 0L
            var mul = 1

            for (i in 0 until divider) {
                sum1 += mul * (i + 1) * a[section * divider + i]
                sum2 += mul * a[section * divider + i]
                mul = -mul
            }

            sum1 to sum2
        }

        val cache = (0 until a.size / divider).map(calcSection).toTypedArray()

        var result = 0L

        repeat(q) {
            val operation = readLine()!!.split(' ')

            when (operation[0]) {
                "Q" -> {
                    val (l, r) = operation.slice(1..2).map { it.toInt() }
                    val startSection = (l + divider - 2) / divider
                    val endSection = r / divider
                    var mul = 1 // ok since divider is even

                    if (((l - 1) % divider > 0) || (startSection >= endSection)) {
                        val r0 = if (startSection >= endSection) r else startSection * divider

                        for (i in l..r0) {
                            result += mul * (i - l + 1) * a[i - 1]
                            mul = -mul
                        }
                    }

                    for (section in startSection until endSection) {
                        result += mul * cache[section].let { it.first + (section * divider - l + 1) * it.second }
                    }

                    if ((r % divider > 0) && (startSection < endSection)) {
                        val l0 = endSection * divider + 1

                        for (i in l0..r) {
                            result += mul * (i - l + 1) * a[i - 1]
                            mul = -mul
                        }
                    }
                }

                "U" -> {
                    val (x, v) = operation.slice(1..2).map { it.toInt() }
                    val section = (x - 1) / divider
                    a[x - 1] = v
                    cache[section] = calcSection(section)
                }
            }
        }

        println("Case #$case: $result")
    }
}
