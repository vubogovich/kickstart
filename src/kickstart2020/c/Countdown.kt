package kickstart2020.c

fun main() {
    val inputFileName = "src/kickstart2020/c/Countdown.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val (_, k) = readLine()!!.split(' ').map { it.toInt() }

        var expect = 0
        var count = 0

        readLine()!!.split(' ')
            .map { it.toInt() }
            .forEach {
                if (it == k) expect = k

                if (it == expect) {
                    expect--
                    if (expect == 0) count++
                } else {
                    expect = 0
                }
            }


        println("Case #$case: $count")
    }
}
