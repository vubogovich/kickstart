package kickstart2020.c

fun main() {
    val inputFileName = "src/kickstart2020/c/StableWall.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (rows, _) = readLine()!!.split(' ').map { it.toInt() }
        val wall = Array(rows) { readLine()!! }.reversed() // 0 is ground

        val labels = wall.map { it.toSet() }.reduce { acc, row -> acc + row }

        var result = ""
        var prevLength = -1

        while (result.length != prevLength) {
            prevLength = result.length

            labels.filter { it !in result }.forEach { label ->
                val isStable = wall.indices.all { row ->
                    wall[row].indices
                        .filter { col -> wall[row][col] == label }
                        .all { col ->
                            val prev = if (row == 0) label else wall[row - 1][col]
                            (prev == label) || (prev in result)
                        }
                }

                if (isStable) result += label
            }
        }

        if (result.length < labels.size) result = "-1"

        println("Case #$case: $result")
    }
}
