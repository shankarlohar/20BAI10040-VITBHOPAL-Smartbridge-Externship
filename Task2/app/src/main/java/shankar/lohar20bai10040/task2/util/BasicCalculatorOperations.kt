package shankar.lohar20bai10040.task2.util

fun add(a: String, b: String): String{
    val result = a.toInt() + b.toInt()
    return result.toString()
}

fun sub(a: String, b: String): String{
    val result = a.toInt() - b.toInt()
    return result.toString()
}

fun mul(a: String, b: String): String{
    val result = a.toInt() * b.toInt()
    return result.toString()
}

fun div(a: String, b: String): String{
    val result = a.toInt() / b.toInt()
    return result.toString()
}