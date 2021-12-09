package com.github.flombois.aoc.days

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class Day3Part2ChallengeTest {

    @Test
    fun test() {
        val challenge = Day3Part2Challenge()
        assertNotNull(challenge)
        assertEquals(3, challenge.day)
        assertEquals(2, challenge.part)
        assertEquals(230, Integer.valueOf(challenge.computeSolution()))
    }
}