package com.github.flombois.aoc.days

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day1Part1ChallengeTest {

    @Test
    fun test() {
        var challenge = Day1Part1Challenge()
        assertEquals(1, challenge.day)
        assertEquals(1, challenge.part)
        assertEquals(7, Integer.valueOf(challenge.computeSolution()))
    }
}