package kickstart2022.g

fun main() {
    val inputFileName = "src/kickstart2022/g/Walktober.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (m, n, p) = readLine()!!.split(' ').map { it.toInt() }
        val s = Array(m) { readLine()!!.split(' ').map { it.toInt() } }

        val res = (0 until n).map { j ->
            val max = (0 until m).maxOf { i -> s[i][j] }
            max - s[p - 1][j]
        }.sum()

        println("Case #$case: $res")
    }
}
