package com.github.flombois.aoc

import java.lang.Exception
import java.net.URL
import java.time.LocalDate
import java.time.Month

/**
 * Contract for a AOC challenge
 */
interface AOChallenge {
    /**
     * Challenge day, must be included in range [1-25] and read-only
     */
    val day: Int

    /**
     * Challenge year, must be read-only
     */
    val year: Int

    /**
     * By default fetch the description if present on the classpath
     * @return A the challenge description
     */
    fun getDescription(): String {
        return getResourceContent("/descriptions/day${this.day}.txt")
    }

    fun getDate(): LocalDate {
        return LocalDate.of(this.year , Month.DECEMBER, this.day)
    }

    fun getInput(): String {
        return getResourceContent("/inputs/day${this.day}.txt")
    }

    fun computeSolution(): String {
        return solution(getInput())
    }

    fun solution(input: String): String

    fun getResourceAsURL(path: String): URL? {
        return this::class.java.getResource(path)
    }

    fun getResourceContent(path: String): String {
        return getResourceAsURL(path)?.readText() ?: throw Exception("Cannot read content of $path")
    }
}

/**
 * Contract specific for AOC 2021 challenges
 */
interface AOChallenge2021 : AOChallenge {
    override val year: Int
        get() = 2021
}