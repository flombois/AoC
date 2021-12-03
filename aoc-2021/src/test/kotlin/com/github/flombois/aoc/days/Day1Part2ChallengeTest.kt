package com.github.flombois.aoc.days

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day1Part2ChallengeTest {

    @Test
    fun test() {
        var challenge = Day1Part2Challenge()
        assertEquals(1, challenge.day)
        assertEquals(2, challenge.part)
        assertEquals(5, Integer.valueOf(challenge.computeSolution()))
    }
}