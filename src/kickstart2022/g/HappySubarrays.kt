package kickstart2022.g

fun main() {
    val inputFileName = "src/kickstart2022/g/HappySubarrays.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!! // n
        val a = readLine()!!.split(' ').map { it.toInt() }
        val groups = mutableListOf<Group>()

        val res = a.map { ai ->
            if (ai < 0) {
                while (groups.size > 0 && groups.last().getMin() < -ai) {
                    if (groups.last().removeSmallerThan(-ai)) groups.removeLast()
                }
            } else if (groups.size > 0 && groups.last().items.size < 1000) {
                groups.last().addZero()
            } else {
                groups.add(Group())
            }

            groups.forEach { it.addToAll(ai) }
            groups.sumOf { it.getTotal() }
        }.sum()

        println("Case #$case: $res")
    }
}

data class Group(
    val items: MutableList<Int> = mutableListOf(0),
    var sum: Int = 0,
    var plus: Int = 0
) {
    fun getMin(): Int {
        return this.items.last() + this.plus
    }

    fun getTotal(): Long {
        return this.sum + this.items.size * this.plus.toLong()
    }

    fun addZero() {
        this.items.add(-this.plus)
        this.sum -= this.plus
    }

    fun addToAll(value: Int) {
        this.plus += value
    }

    fun removeSmallerThan(value: Int): Boolean {
        this.items.removeIf { it + this.plus < value }
        this.sum = this.items.sum()
        return this.items.size == 0
    }
}
