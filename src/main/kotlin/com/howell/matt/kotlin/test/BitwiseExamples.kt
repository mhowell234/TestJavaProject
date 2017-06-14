package com.howell.matt.kotlin.test

import com.google.common.base.Stopwatch
import java.util.concurrent.TimeUnit
import java.util.function.Function

/**
 * Bitwise examples.
 */
class BitwiseExamples {

    val log = loggerFor(::BitwiseExamples.javaClass)

    /**
     * Number of iterations to determine average runtime.
     */
    private val ITERATIONS = 1_000_000L

    companion object {

        /**
         * Main.
         *
         * @param args args
         */
        @JvmStatic fun main(args: Array<String>) {
            val examples = BitwiseExamples()

            examples.bitwiseExamples()
        }
    }

    /**
     * Bitwise examples.
     */
    fun bitwiseExamples() {
        log.info("Bitwise: {}", averageTime(Function<Int, Boolean> { oddWithBitwise(it) }, 3))
        log.info("Modulo: {}", averageTime(Function<Int, Boolean> { oddWithModulo(it) }, 3))
    }

    /**
     * Determine average runtime of methods.
     *
     * @param func  function
     * @param value value
     * @return average time
     */
    fun averageTime(func: Function<Int, Boolean>, value: Int?): Long {
        val stopwatch = Stopwatch.createStarted()
        var loopIteration = 0
        while (loopIteration < ITERATIONS) {
            func.apply(value!!)
            loopIteration++
        }
        return stopwatch.stop().elapsed(TimeUnit.MILLISECONDS) / ITERATIONS
    }

    /**
     * Determine if a number is odd with bitwise logic.
     *
     * @param number number
     * @return if the number is odd
     */
    fun oddWithBitwise(number: Int): Boolean {
        return number and 1 == 0
    }

    /**
     * Determine if a number is odd with modulo logic.
     *
     * @param number number
     * @return if the number is odd
     */
    fun oddWithModulo(number: Int): Boolean {
        return number % 2 != 0
    }
}
