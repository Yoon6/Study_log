package example

open class Tiger(val origin: String, val male: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
        println("$male")
    }
}

class SiberianTiger : Tiger("Siberia", "Female")                  // 1

fun main() {
    val tiger: Tiger = SiberianTiger()
    tiger.sayHello()
}