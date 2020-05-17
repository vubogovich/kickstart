#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}

#end
fun main() {
    val inputFileName = "${DIR_PATH}/${NAME}.in"
    java.io.File(inputFileName).takeIf { it.exists() }?.also { System.setIn(it.inputStream()) }

    for (case in 1..readLine()!!.toInt()) {
        TODO("Not solved yet")
        println("Case #$case: OK")
    }
}
