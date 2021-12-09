package com.github.flombois.aoc.days

import com.github.flombois.aoc.AOChallenge2021

/**
 * Single loop solution, only loop once through the input
 */
class Day3Part2Challenge : AOChallenge2021 {

    override val day: Int
        get() = 3
    override val part: Int
        get() = 2


    override fun computeSolution(): String {
        val lines = getInput().lines()
        val oxygenRate = Integer.parseInt(searchOxygenRate(ArrayList(lines)), 2)
        println(oxygenRate)

        val co2Rate = Integer.parseInt(searchCO2Rate(ArrayList(lines)), 2)
        println(co2Rate)


        return (oxygenRate*co2Rate).toString()
    }

    private fun searchCO2Rate(lines: ArrayList<String>): String {
        // Loop until there is only one element
        var digiCounter = 0
        while(lines.size > 1) {
            println(lines)
            if(countBit(lines, BIT.ONE, digiCounter) * 2 >= lines.size) {
                lines.removeIf { line -> BIT.isOne(line[digiCounter]) }
            } else {
                lines.removeIf { line -> BIT.isZero(line[digiCounter]) }
            }

            digiCounter++
        }
        println(lines)
        return lines[0]
    }

    private fun searchOxygenRate(lines: ArrayList<String>): String {
        // Loop until there is only one element
        var digiCounter = 0
        while(lines.size > 1) {
            println(lines)
            if(countBit(lines, BIT.ONE, digiCounter) * 2 >= lines.size) {
                lines.removeIf { line -> BIT.isZero(line[digiCounter]) }
            } else {
                lines.removeIf { line -> BIT.isOne(line[digiCounter]) }
            }

            digiCounter++
        }
        println(lines)
        return lines[0]
    }

    private fun countBit(lines: List<String>, bit: BIT, offset: Int): Int {
        var count = 0
        for(line in lines) {
            if(BIT.parse(line[offset]) == bit) {
                count++
            }
        }
        return count
    }


    enum class BIT {
        ZERO, ONE;

        companion object {
            fun parse(char: Char): BIT {
                if(char == '0') return ZERO
                return ONE
            }

            fun isOne(char: Char): Boolean {
                return parse(char) == ONE
            }

            fun isZero(char: Char): Boolean {
                return !isOne(char)
            }
        }
    }
}
