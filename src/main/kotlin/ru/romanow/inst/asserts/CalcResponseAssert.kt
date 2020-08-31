package ru.romanow.inst.asserts

class CalcResponseAssert {
    fun isCorrect(result: Int, expected: Int) = result.equals(expected)
}