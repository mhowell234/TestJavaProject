package com.howell.matt.test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.google.common.base.Stopwatch;

import lombok.extern.slf4j.Slf4j;

/**
 * Bitwise examples.
 */
@Slf4j
public final class BitwiseExamples {

    /**
     * Number of iterations to determine average runtime.
     */
    private static final Long ITERATIONS = 1_000_000L;

    private BitwiseExamples() {
    }

    /**
     * Bitwise examples.
     */
    public static void bitwiseExamples() {
        log.info("Bitwise: {}", averageTime(BitwiseExamples::oddWithBitwise, 3));
        log.info("Modulo: {}", averageTime(BitwiseExamples::oddWithModulo, 3));
    }

    /**
     * Determine if a number is odd with bitwise logic.
     *
     * @param number number
     * @return if the number is odd
     */
    public static boolean oddWithBitwise(final int number) {
        return (number & 1) == 0;
    }

    /**
     * Determine if a number is odd with modulo logic.
     *
     * @param number number
     * @return if the number is odd
     */
    public static boolean oddWithModulo(final int number) {
        return number % 2 != 0;
    }

    /**
     * Determine average runtime of methods.
     *
     * @param func  function
     * @param value value
     * @return average time
     */
    public static long averageTime(final Function<Integer, Boolean> func, final Integer value) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int loopIteration = 0;
        for (; loopIteration < ITERATIONS; loopIteration++) {
            func.apply(value);
        }
        return stopwatch.stop().elapsed(TimeUnit.MILLISECONDS) / ITERATIONS;
    }

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        bitwiseExamples();
    }
}
