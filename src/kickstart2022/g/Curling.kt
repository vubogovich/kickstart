package kickstart2022.g

fun main() {
    val inputFileName = "src/kickstart2022/g/Curling.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (rs, rh) = readLine()!!.split(' ').map { it.toInt() }
        val n = readLine()!!.toInt()
        val np = Array(n) { readLine()!!.split(' ').map { it.toInt() } }
        val m = readLine()!!.toInt()
        val mp = Array(m) { readLine()!!.split(' ').map { it.toInt() } }

        val maxDistance2 = (rs + rh) * (rs + rh)

        val nd = np.map { (x, y) -> x * x + y * y }
            .filter { d2 -> d2 <= maxDistance2 }
            .sorted()

        val md = mp.map { (x, y) -> x * x + y * y }
            .filter { d2 -> d2 <= maxDistance2 }
            .sorted()

        val nf = nd.firstOrNull() ?: Int.MAX_VALUE
        val mf = md.firstOrNull() ?: Int.MAX_VALUE

        val (nr, mr) = when {
            nd.size + md.size == 0 -> 0 to 0
            nf < mf -> nd.count { it < mf } to 0
            else -> 0 to md.count { it < nf }
        }

        println("Case #$case: $nr $mr")
    }
}
