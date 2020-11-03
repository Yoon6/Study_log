fun main(args: Array<String>){

    val withoutMargin1 = """ABC
                |123
                |456 
                |aaa|bbb""".trimMargin()
    println(withoutMargin1)

    println(month)
    println("11 JAN 2019".matches(getPattern().toRegex()))
}

val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2} ${month} \d{4}"""

fun a(master : Int){}
fun b(master : Int){}