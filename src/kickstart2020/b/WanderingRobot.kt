package kickstart2020.b

// TODO test set 2
fun main() {
    val inputFileName = "src/kickstart2020/b/WanderingRobot.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val params = readLine()!!.split(' ').map { it.toInt() }
        val (width, height) = params.slice(0..1)
        val (left, top) = params.slice(2..3)
        val (right, bottom) = params.slice(4..5)

        val probs = Array(width + 1) { DoubleArray(height + 1) { 0.0 } }

        probs[0][1] = 1.0
        probs[1][0] = 1.0

        for (x in 1..width) {
            for (y in 1..height) {
                if ((x in left..right) && (y in top..bottom)) continue
                probs[x][y] += probs[x][y - 1] * (if (x == width) 1.0 else 0.5)
                probs[x][y] += probs[x - 1][y] * (if (y == height) 1.0 else 0.5)
            }
        }

        println("Case #$case: ${probs[width][height]}")
    }
}
