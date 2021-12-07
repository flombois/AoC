package com.github.flombois.aoc.days

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class Day3Part1ChallengeTest {

    @Test
    fun test() {
        val challenge = Day3Part1Challenge()
        assertNotNull(challenge)
        assertEquals(3, challenge.day)
        assertEquals(1, challenge.part)
        assertEquals(198, Integer.valueOf(challenge.computeSolution()))
    }

    @ParameterizedTest
    @CsvSource(
        "0,000",
        "1,001",
        "2,010",
        "3,011",
        "4,100",
        "5,101",
        "6,110",
        "7,111",
    )
    fun parseShort(expected: Short, str: String) {
        val challenge = Day3Part1Challenge()
        val message = "'$str' should be parsed as $expected"
        assertEquals(expected, challenge.parseShort(str),message)

    }

    @ParameterizedTest
    @CsvSource(
        "false,0,0",
        "true,1,0",
        "false,0,1",
        "false,2,0",
        "true,2,1"
    )
    fun bitAt(expected: Boolean, short: Short, offset: Int) {
        val challenge = Day3Part1Challenge()
        assertEquals(expected, challenge.bitAt(short, offset))
    }
}