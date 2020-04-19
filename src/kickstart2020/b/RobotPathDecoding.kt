package kickstart2020.b

fun main() {
    val inputFileName = "src/kickstart2020/b/RobotPathDecoding.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    val max = 1000000000L

    for (case in 1..readLine()!!.toInt()) {
        var x = 0L
        var y = 0L
        val sub = mutableListOf<LongArray>()

        readLine()!!.forEach {
            when (it) {
                'N' -> y--
                'S' -> y++
                'E' -> x++
                'W' -> x--
                in '1'..'9' -> sub.add(longArrayOf(x, y, it.toLong() - 48))
                '(' -> { x = 0; y = 0 }
                ')' -> {
                    val (px, py, mul) = sub.removeAt(sub.lastIndex)
                    x = (px + x * mul + max) % max
                    y = (py + y * mul + max) % max
                }
            }
        }

        if (x < 0) x += max
        if (y < 0) y += max

        println("Case #$case: ${x + 1} ${y + 1}")
    }
}
