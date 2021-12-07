package com.github.flombois.aoc.days

import com.github.flombois.aoc.AOChallenge2021

class Day3Part1Challenge: AOChallenge2021 {

    override val day: Int
        get() = 3
    override val part: Int
        get() = 1

    override fun computeSolution(): String {
        val digits: Int = getInput().lines()[0].length
        val shorts: List<Short> = getInput().lines().map(this::parseShort)
        var gamma: Int = 0
        for(i in (digits -1) downTo 0) {
            val x: Short = if(isOneMostFrequentBit(i, shorts)) shiftOneLeft(i)
            else shiftZeroLeft(i)
            gamma = (gamma + x).toInt()
        }
        var mask = if(digits == 5) 0x1F else 0x0FFF
        val epsilon = (gamma.inv() and mask)
        val consumption = gamma * epsilon
        println("gamma = $gamma")
        println("epsilon = $epsilon")
        println("consumption = $consumption")
        return  consumption.toString()
    }

    fun isOneMostFrequentBit(offset: Int, shorts: List<Short>): Boolean {
        var bitCounter = 0
        for(short in shorts) {
            if(bitAt(short, offset)) bitCounter++
        }
        return ( 2*bitCounter > shorts.size)
    }

    // false = 0, true = 1
    fun bitAt(short: Short, offset: Int): Boolean {
        // shift right and mask
        return ((short.toInt() shr offset) and 1) == 1
    }

    fun parseShort(str: String): Short {
        var retVal: Short = 0
        val chars: CharArray = str.toCharArray()
        var i = chars.size
        for(char in chars) {
            i--
            retVal = (retVal + charToShort(char, i)).toShort()
        }
        return retVal
    }

    private fun charToShort(char: Char, offset: Int): Short {
        return if('0' == char) shiftZeroLeft(offset)
        else shiftOneLeft(offset)
    }

    private fun shiftZeroLeft(offset: Int): Short {
        return (0 shl offset).toShort()
    }

    private fun shiftOneLeft(offset: Int): Short {
        return (1 shl offset).toShort()
    }
}