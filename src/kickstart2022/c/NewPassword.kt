package kickstart2022.c

fun main() {
    val inputFileName = "src/kickstart2022/c/NewPassword.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    val specialChars = setOf('#', '@', '*', '&')

    for (case in 1..readLine()!!.toInt()) {
        readLine() // n
        val old = readLine()!!
        val lowers = old.any { it in 'a'..'z' }
        val uppers = old.any { it in 'A'..'Z' }
        val digits = old.any { it in '0'..'9' }
        val specials = old.any { it in specialChars }

        val res = listOf(
            old,
            if (lowers) "" else "a",
            if (uppers) "" else "A",
            if (digits) "" else "0",
            if (specials) "" else specialChars.first(),
        )
            .joinToString("")
            .padEnd(7, '0')

        println("Case #$case: $res")
    }
}
