package kickstart2020.c

// TODO test set 2
fun main() {
    val inputFileName = "src/kickstart2020/c/PerfectSubarray.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    val squares = Array(10000001) { false }

    (0..10000).map { it * it }.filter { it in squares.indices }.forEach { squares[it] = true }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!!.toInt() // a.size
        val a = readLine()!!.split(' ').map { it.toInt() }

        var count = 0L

        for (i in a.indices) {
            var sum = 0

            for (j in i until a.size) {
                sum += a[j]
                if ((sum >= 0) && squares[sum]) count++
            }
        }

        println("Case #$case: $count")
    }
}
