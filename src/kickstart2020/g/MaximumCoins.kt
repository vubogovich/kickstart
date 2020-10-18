package kickstart2020.g

fun main() {
    val inputFileName = "src/kickstart2020/g/MaximumCoins.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        val sums = Array(n * 2) { 0L }

        for (row in 0 until n) {
            readLine()!!.split(' ')
                .map { it.toLong() }
                .forEachIndexed { col, value -> sums[col + n - row] += value }
        }

        println("Case #$case: ${sums.max()}")
    }
}
