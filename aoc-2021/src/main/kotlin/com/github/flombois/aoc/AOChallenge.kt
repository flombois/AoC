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
     * Challenge part
     */
    val part: Int

    /**
     * Challenge year, must be read-only
     */
    val year: Int

    /**
     * By default fetch the description if present on the classpath
     * @return A the challenge description
     */
    fun getDescription(): String {
        return getResourceContent("/descriptions/${this.getInputFilename()}")
    }

    fun getDate(): LocalDate {
        return LocalDate.of(this.year , Month.DECEMBER, this.day)
    }

    fun getInput(): String {
        return getResourceContent("/inputs/${this.getInputFilename()}")
    }

    fun getInputFilename(): String {
        return "day${this.day}part${this.part}.txt"
    }

    fun solve() {
        println(getDescription() + "\n")
        println("Computing solution for Day: ${this.day} Part: ${this.part} (${this.getDate()})")
        println(computeSolution())
    }

    fun computeSolution(): String

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