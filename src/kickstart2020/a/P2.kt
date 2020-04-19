package kickstart2020.a

fun main() {
    val inputFileName = "src/kickstart2020/a/P2.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        println("Case #$case: OK")
    }
}
