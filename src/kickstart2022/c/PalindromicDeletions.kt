package kickstart2022.c

// TODO
fun main() {
    val inputFileName = "src/kickstart2022/c/PalindromicDeletions.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        readLine()!!.split(' ').map { it.toInt() }

        println("Case #$case: OK")
    }
}
