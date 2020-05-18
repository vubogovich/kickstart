package kickstart2020.a

fun main() {
    val inputFileName = "src/kickstart2020/a/Allocation.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (_, budget) = readLine()!!.split(' ').map { it.toInt() }
        val costs = readLine()!!.split(' ').map { it.toInt() }.sorted()

        var count = 0
        var spent = 0

        while ((count < costs.size) && (spent + costs[count] <= budget)) {
            spent += costs[count]
            count++
        }

        println("Case #$case: $count")
    }
}
