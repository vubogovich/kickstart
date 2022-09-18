package kickstart2022.f

fun main() {
    val inputFileName = "src/kickstart2022/f/SortFabrics.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val n = readLine()!!.toInt()

        val fabrics = Array(n) { index ->
            val (color, durability, id) = readLine()!!.split(' ')

            Fabric(
                index,
                color,
                durability.toInt(),
                id.toInt()
            )
        }

        val ada = fabrics.sortedWith(compareBy(Fabric::color, Fabric::id)).map(Fabric::index)
        val charles = fabrics.sortedWith(compareBy(Fabric::durability, Fabric::id)).map(Fabric::index)
        val sameOrder = fabrics.indices.count { index -> ada[index] == charles[index] }

        println("Case #$case: $sameOrder")
    }
}

data class Fabric(val index: Int, val color: String, val durability: Int, val id: Int)
