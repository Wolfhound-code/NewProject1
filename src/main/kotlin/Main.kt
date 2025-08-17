package org.example

import jdk.internal.foreign.abi.riscv64.RISCV64Architecture.Regs.x1
import jdk.internal.foreign.abi.riscv64.RISCV64Architecture.Regs.x2
import jdk.jfr.DataAmount
import kotlin.math.max
import kotlin.math.roundToInt

fun main() {
    println("Введите длину первой стороны:")
    val a = readLine()?.toDouble() ?: 16.0
    println("Введите длину второй стороны:")
    val b = readLine()?.toDouble() ?: 22.0
    calcFenceMaterials(a, b)
}
fun calcFenceMaterials(a: Double, b: Double) {
    val minSide = 2
    val maxSide = 300
    val polesGap = 2.5
    val listWidth = 1.15
    if (a < minSide || b < minSide) {
        println("Стороны участка должны быть не менее $minSide метров")
        return
    }
    if (a > maxSide || b > maxSide) {
        println("Стороны участка должны быть не более $maxSide метров")
        return
    }
    val perimetr = 2 * (a + b)
    val polesAmount = ((perimetr / polesGap) * 1.1).roundToInt()
    val fenceListAmount = ((perimetr / listWidth) * 1.15).roundToInt()
    println("Необходимое количество столбов: $polesAmount")
    println("Необходимое количество листов профлиста: $fenceListAmount")
}