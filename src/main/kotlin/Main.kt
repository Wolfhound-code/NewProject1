package org.example

import jdk.jfr.DataAmount

fun main() {
    val encoded = "F2p)v\"y233{0->c}ttelciFc"
    val firstHalf = encoded.substring(0, encoded.length / 2)
    val secondHalf = encoded.substring(encoded.length / 2)
    println("first half is: $firstHalf")
    println("second half is: $secondHalf")
    val decryptedFirstHalf = transcriptFirstHalf(firstHalf)
    val decryptedSecondHalf = transcriptSecondHalf(secondHalf)
    val result = "$decryptedFirstHalf$decryptedSecondHalf"
    println("""
        decrypted firstHalf: $decryptedFirstHalf
        decrypted secondHalf: $decryptedSecondHalf
        result: $result
    """.trimIndent())
}
fun transcriptFirstHalf(encoded: String): String {
    var result: String = encoded
    result = moveRight(result, 1)
    result = result.replace('5', 's')
    result = result.replace('4', 'u')
    result = moveLeft(result, 3)
    result = result.replace('0', 'o')
    return result
}
fun transcriptSecondHalf(encoded: String): String {
    var result: String = encoded
    result = result.reversed()
    result = moveLeft(result, 4)
    result = result.replace('_', ' ')
    return result
}
fun moveRight(encoded: String, amount: Int): String {
    return encoded.map { c -> c + amount}.joinToString("")
}
fun moveLeft(encoded: String, amount: Int): String {
    return encoded.map { c -> c - amount }.joinToString("")
}




