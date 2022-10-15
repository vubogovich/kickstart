package kickstart2022.g

// TODO
fun main() {
    val inputFileName = "src/kickstart2022/g/CuteLittleButterfly.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, e) = readLine()!!.split(' ').map { it.toInt() }

        val f = Array(n) {
            val (x, y, c) = readLine()!!.split(' ').map { it.toInt() }
            Flower(x, y, c)
        }.toList()

        val res = findBestWay(0, 500, 1, f, e)

        println("Case #$case: $res")
    }
}

data class Flower(val x: Int, val y: Int, val c: Int)

fun findBestWay(x: Int, y: Int, d: Int, f: List<Flower>, e: Int): Int {
    val g = f.filter { it.y <= y }

    return g.mapIndexed { i, it ->
        when {
            g.size == 1 && it.x * d >= x * d -> it.c
            g.size == 1 && it.x * d <= x * d && it.c > e -> it.c - e
            g.size > 1 && it.x * d >= x * d -> it.c + findBestWay(it.x, it.y, d, g.filterIndexed { j, _ -> i != j }, e)
            g.size > 1 && it.x * d <= x * d && it.c > e -> it.c - e + findBestWay(it.x, it.y, -d, g.filterIndexed { j, _ -> i != j }, e)
            else -> 0
        }
    }.maxOrNull() ?: 0
}
