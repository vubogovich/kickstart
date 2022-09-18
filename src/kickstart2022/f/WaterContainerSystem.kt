package kickstart2022.f

fun main() {
    val inputFileName = "src/kickstart2022/f/WaterContainerSystem.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, q) = readLine()!!.split(' ').map { it.toInt() }
        val pairs = Array(n - 1) { readLine()!!.split(' ').map { it.toInt() } }.toMutableList()
        Array(q) { readLine()!!.toInt() }

        val levels = Array(n + 1) { 0 }
        levels[1] = 1

        while (pairs.size > 0) {
            pairs.indices.reversed().forEach { index ->
                val (first, second) = pairs[index]

                if (levels[first] > 0) {
                    levels[second] = levels[first] + 1
                    pairs.removeAt(index)
                } else if (levels[second] > 0) {
                    levels[first] = levels[second] + 1
                    pairs.removeAt(index)
                }
            }
        }

        var result = 0
        var level = 1

        while (result < q) {
            val count = levels.count { it == level }
            if (result + count > q) break
            result += count
            level++
        }

        println("Case #$case: $result")
    }
}
