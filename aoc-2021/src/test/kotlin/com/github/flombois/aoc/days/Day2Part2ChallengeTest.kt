package com.github.flombois.aoc.days

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class Day2Part2ChallengeTest {

    @Test
    fun test() {
        val challenge = Day2Part2Challenge()
        assertNotNull(challenge)
        assertEquals(2, challenge.day)
        assertEquals(2, challenge.part)
        assertEquals(900, Integer.valueOf(challenge.computeSolution()))
    }
}