package com.github.flombois.aoc.days

import com.github.flombois.aoc.AOChallenge2021

class Day1Part1Challenge: AOChallenge2021 {

    override val day: Int
        get() = 1

    override val part: Int
        get() = 1

    override fun computeSolution(input: String): String {
        var counter: Int = -1
        var current: Int = Integer.MIN_VALUE
        var previous: Int = Integer.MIN_VALUE

        val i: Iterator<String> = input.split("\n").listIterator()
        while(i.hasNext()) {
            current = i.next().toInt()
            if(current > previous)
                counter++
            previous = current
        }

        return counter.toString()
    }
}