package kickstart2022.d

fun main() {
    val inputFileName = "src/kickstart2022/d/ImageLabeler.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, m) = readLine()!!.split(' ').map { it.toInt() }
        val a = readLine()!!.split(' ').map { it.toInt() }.sorted()
        val x = n - m + 1
        val med = if (x % 2 == 0) (a[x / 2 - 1].toDouble() + a[x / 2]) / 2 else a[(x - 1) / 2].toDouble()
        val res = med + a.subList(x, a.size).sum()
        println("Case #$case: $res")
    }
}
