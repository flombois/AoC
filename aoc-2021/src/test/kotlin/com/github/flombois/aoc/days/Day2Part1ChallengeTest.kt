package com.github.flombois.aoc.days

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class Day2Part1ChallengeTest {

    @Test
    fun test() {
        var challenge = Day2Part1Challenge()
        assertNotNull(challenge)
        assertEquals(2, challenge.day)
        assertEquals(1, challenge.part)
        assertEquals(150, Integer.valueOf(challenge.computeSolution()))
    }
}