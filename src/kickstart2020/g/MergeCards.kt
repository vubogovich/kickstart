package kickstart2020.g

// TODO
fun main() {
    val inputFileName = "src/kickstart2020/g/MergeCards.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!!.split(' ').map { it.toInt() }

        println("Case #$case: OK")
    }
}
