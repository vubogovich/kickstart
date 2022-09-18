package kickstart2022.f

// TODO test set 3
fun main() {
    val inputFileName = "src/kickstart2022/f/StoryOfSeasons.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (d, n, x) = readLine()!!.split(' ').map { it.toInt() }

        val days = Array(d) { x }
        val freeDay = Array(d) { it }

        val seeds = Array(n) {
            val (q, l, v) = readLine()!!.split(' ').map { it.toInt() }
            Seed(q, l, v)
        }

        val result = seeds.sortedWith(compareBy(Seed::v, Seed::l).reversed())
            .map {
                var q = it.q
                var i = d - it.l - 1

                while (q > 0 && i >= 0) {
                    while (i >= 0 && freeDay[i] < i) i = freeDay[i]
                    if (i < 0) break
                    freeDay[i] = i - q / x

                    val m = Math.min(q, days[i])
                    days[i] -= m
                    q -= m
                    i--
                }

                it.v.toLong() * (it.q - q)
            }
            .sum()

        println("Case #$case: $result")
    }
}

data class Seed(val q: Int, val l: Int, val v: Int)
