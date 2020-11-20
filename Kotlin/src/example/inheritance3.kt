package example

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

class Asiatic(name: String, origin: String) : Lion(name = name, origin = origin) // 1

fun main() {
    val lion: Lion = Asiatic("Rufo", "India")                              // 2
    lion.sayHello()
}