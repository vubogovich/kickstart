package kickstart2020.b

fun main() {
    val inputFileName = "src/kickstart2020/b/BikeTour.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!!.toInt() // heights.size
        val heights = readLine()!!.split(' ').map { it.toInt() }

        val count = (1 until heights.size - 1).count {
            (heights[it] > heights[it - 1]) && (heights[it] > heights[it + 1])
        }

        println("Case #$case: $count")
    }
}
