package kickstart2022.c

// TODO test set 2
fun main() {
    val inputFileName = "src/kickstart2022/c/AntsOnStick.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (n, len) = readLine()!!.split(' ').map { it.toInt() }

        val ants = Array(n) {
            val (p, d) = readLine()!!.split(' ').map { it.toInt() }
            Ant(it + 1, p, if (d == 1) Direction.RIGHT else Direction.LEFT)
        }
            .sortedBy { it.pos }
            .toMutableList()

        var time = 0L
        val drops = mutableListOf<Drop>()

        while (ants.size > 0) {
            while (ants.size > 0 && ants[0].dir == Direction.LEFT) {
                drops.add(Drop(ants[0].num, time + ants[0].pos))
                ants.removeAt(0)
            }

            while (ants.size > 0 && ants.last().dir == Direction.RIGHT) {
                drops.add(Drop(ants.last().num, time + len - ants.last().pos))
                ants.removeLast()
            }

            var minLen = Int.MAX_VALUE

            for (i in 0 until ants.size - 1) {
                if (ants[i].dir == Direction.RIGHT
                    && ants[i + 1].dir == Direction.LEFT
                    && ants[i + 1].pos - ants[i].pos < minLen
                ) {
                    minLen = ants[i + 1].pos - ants[i].pos
                }
            }

            if (minLen < Int.MAX_VALUE) {
                val move = (minLen + 1) / 2

                for (k in ants.indices) {
                    ants[k].pos += if (ants[k].dir == Direction.RIGHT) move else -move
                }

                for (k in 0 until ants.size - 1) {
                    if (ants[k].pos > ants[k + 1].pos
                        && ants[k].dir == Direction.RIGHT
                        && ants[k + 1].dir == Direction.LEFT
                    ) {
                        ants[k].pos--
                        ants[k].dir = Direction.LEFT
                        ants[k + 1].pos++
                        ants[k + 1].dir = Direction.RIGHT
                    }
                }

                for (k in 0 until ants.size - 1) {
                    if (ants[k].pos == ants[k + 1].pos
                        && ants[k].dir == Direction.RIGHT
                        && ants[k + 1].dir == Direction.LEFT
                    ) {
                        ants[k].dir = Direction.LEFT
                        ants[k + 1].dir = Direction.RIGHT
                    }
                }

                time += move
            }
        }

        val res = drops.sortedWith(compareBy(Drop::time, Drop::num))
            .map { it.num }
            .joinToString(" ")

        println("Case #$case: $res")
    }
}

enum class Direction {
    LEFT,
    RIGHT
}

data class Ant(var num: Int, var pos: Int, var dir: Direction)

data class Drop(val num: Int, val time: Long)
