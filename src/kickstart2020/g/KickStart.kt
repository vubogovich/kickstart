package kickstart2020.g

fun main() {
    val inputFileName = "src/kickstart2020/g/KickStart.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        val s = readLine()!!
        var sp = 0

        val starts = generateSequence(-1) { prev ->
            s.indexOf("START", prev + 1).takeIf { it >= 0 }
        }.drop(1).toList()

        generateSequence(-1) { prev ->
            s.indexOf("KICK", prev + 1).takeIf { it >= 0 }
        }.drop(1).map {
            while (sp < starts.size && starts[sp] < it) sp++
            starts.size - sp
        }.sum().let {
            println("Case #$case: $it")
        }
    }
}
