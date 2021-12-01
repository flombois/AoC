package com.github.flombois.aoc

import java.util.*

class Day1Challenge: AOChallenge2021 {

    override val day: Int
        get() = 1

    override fun solution(input: String): String {
        var counter: Int = -1
        var current: Int = Integer.MIN_VALUE
        var previous: Int = Integer.MIN_VALUE

        val i: Iterator<String> = input.split(System.lineSeparator()).listIterator()
        while(i.hasNext()) {
            current = i.next().toInt()
            if(current > previous)
                counter++
            previous = current
        }

        return counter.toString()
    }
}