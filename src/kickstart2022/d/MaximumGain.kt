package kickstart2022.d

fun main() {
    val inputFileName = "src/kickstart2022/d/MaximumGain.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine() // n
        val a = readLine()!!.split(' ').map { it.toInt() }
        readLine() // m
        val b = readLine()!!.split(' ').map { it.toInt() }
        val k = readLine()!!.toInt()

        val res = (0..k)
            .map { findMaxSum(a, it) to findMaxSum(b, k - it) }
            .filter { (a, b) -> a >= 0 && b >= 0 }
            .maxOf { (a, b) -> a + b }

        println("Case #$case: $res")
    }
}

fun findMaxSum(a: List<Int>, k: Int): Long {
    if (k > a.size) return -1

    var sum = a.subList(a.size - k, a.size).sumOf { it.toLong() }
    var max = sum

    for (i in 0 until k) {
        sum += a[i] - a[a.size - k + i]
        if (sum > max) max = sum
    }

    return max
}
