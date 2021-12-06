package com.github.flombois.aoc.days

import com.github.flombois.aoc.AOChallenge2021

class Day1Part2Challenge: AOChallenge2021 {

    override val day: Int
        get() = 1

    override val part: Int
        get() = 2

    override fun computeSolution(): String {
        var sumList = slideWindow()
        var i = 0
        var counter = 0
        while(i < sumList.lastIndex) {
            if(sumList[i+1] > sumList[i]) counter++
            i++
        }
        return (counter).toString()
    }


    private fun sum(list : List<Int>) : Int {
        return list.sum()
    }

    private fun slideWindow(): List<Int> {
        val window = Window(3, getInput().split("\n").map(Integer::valueOf))
        val windowSum = mutableListOf<Int>()
        while( window.canSlide(1)) {
            windowSum.add((window.fetch().sum()))
            window.slide(1)
        }
        return windowSum
    }

    class Window(var size: Int, val input: List<Int>) {

        private var offset: Int = 0

        fun fetch(): List<Int> {
            return input.subList(offset, offset+size)
        }

        fun slide(step: Int) {
            if(canSlide(step)) offset += step
        }

        fun canSlide(step: Int): Boolean {
            return offset + size <= input.lastIndex + 1
        }

        fun getOffset(): Int {
            return offset
        }

    }
}