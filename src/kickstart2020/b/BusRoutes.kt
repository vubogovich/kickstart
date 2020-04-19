package kickstart2020.b

fun main() {
    val inputFileName = "src/kickstart2020/b/BusRoutes.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (_, days) = readLine()!!.split(' ').map { it.toLong() }
        val freqs = readLine()!!.split(' ').map { it.toLong() }

        val start = freqs.foldRight(days) { freq, target -> target - target % freq }

        println("Case #$case: $start")
    }
}
