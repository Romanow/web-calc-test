package ru.romanow.inst.web

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import ru.romanow.inst.asserts.CalcResponseAssert

internal class CalcControllerTest {

    @Test
    @DisplayName("Plus test operation")
    fun plusTest() {
        val result = CalcController(2, 4).plus()
        CalcResponseAssert().isCorrect(result.toInt(), 6)
    }

    @Test
    @DisplayName("Minus test operation")
    fun minusTest() {
        val result = CalcController(4, 2).minus()
        CalcResponseAssert().isCorrect(result.toInt(), 2)
    }

    @Test
    @DisplayName("Multiply test operation")
    fun multiplyTest() {
        val result = CalcController(2, 4).multiply()
        CalcResponseAssert().isCorrect(result.toInt(), 8)
    }

    @Test
    @DisplayName("Divide test operation")
    fun divideTest() {
        val result = CalcController(2, 2).divide()
        CalcResponseAssert().isCorrect(result.toInt(), 1)
    }
}