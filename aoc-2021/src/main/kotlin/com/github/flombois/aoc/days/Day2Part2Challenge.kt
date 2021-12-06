package com.github.flombois.aoc.days

import com.github.flombois.aoc.AOChallenge2021
import java.util.stream.Collectors

class Day2Part2Challenge: AOChallenge2021 {

    override val day: Int
        get() = 2
    override val part: Int
        get() = 2

    override fun computeSolution(): String {
        var sub = Submarine(0,0, 0)
        val commands = Command.parse(getInput().lines())

        commands.forEach { cmd: Command -> cmd.update(sub) }

        return sub.getPositionProduct().toString()
    }


    class Submarine(var horizontalPosition: Int, var depthPosition: Int, var aim: Int) {

        fun getPositionProduct(): Int {
            return horizontalPosition * depthPosition
        }
    }


    class Command(val commandType: CommandType, val value: Int) {

        fun update(submarine: Submarine) {
            commandType.updatePosition(submarine, value)
            commandType.updateAim(submarine, value)
        }

        enum class CommandType {
            FORWARD {
                override fun updatePosition(submarine: Submarine, value: Int) {
                    submarine.horizontalPosition += value
                    submarine.depthPosition += value * submarine.aim
                }

                override fun updateAim(submarine: Submarine, value: Int) {
                    // No operation
                }
            },

            UP {
                override fun updatePosition(submarine: Submarine, value: Int) {
                    // No operation
                }

                override fun updateAim(submarine: Submarine, value: Int) {
                    if (value > submarine.aim) submarine.aim = 0
                    else submarine.aim -= value
                }
            },

            DOWN {
                override fun updatePosition(submarine: Submarine, value: Int) {
                    // No operation
                }

                override fun updateAim(submarine: Submarine, value: Int) {
                    submarine.aim += value
                }
            },

            UNKNOWN {
                override fun updatePosition(submarine: Submarine, value: Int) {
                    // No operation
                }

                override fun updateAim(submarine: Submarine, value: Int) {
                    // No operation
                }
            };

            abstract fun updatePosition(submarine: Submarine, value: Int)
            abstract fun updateAim(submarine: Submarine, value: Int)
        }

        companion object Parser {
            fun parse(str: String): Command {
                val cmd = str.split(" ")[0].trim().uppercase()
                val value = str.split(" ")[1].trim().toInt()

                if ("FORWARD".equals(cmd)) return Command(CommandType.FORWARD, value)
                if ("UP".equals(cmd)) return Command(CommandType.UP, value)
                if ("DOWN".equals(cmd)) return Command(CommandType.DOWN, value)
                return Command(CommandType.UNKNOWN, 0)
            }

            fun parse(str: List<String>): List<Command> {
                return str.stream().map(this::parse).collect(Collectors.toList())
            }
        }
    }
}