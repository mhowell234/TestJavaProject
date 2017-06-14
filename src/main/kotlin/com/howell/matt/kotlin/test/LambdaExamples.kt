package com.howell.matt.kotlin.test

import com.amazonaws.regions.Regions
import com.amazonaws.services.lambda.AWSLambdaClientBuilder

/**
 * Lambda examples.
 */
class LambdaExamples {

    val log = loggerFor(::LambdaExamples.javaClass)

    /**
     * Show lambda functions.
     */
    fun showLambdaFunctions() {
        val lambdaClient = AWSLambdaClientBuilder.standard().withRegion(Regions.US_WEST_2).build()
        lambdaClient.listFunctions().functions.stream().map({ it.getFunctionName() }).forEach({ log.info(it) })
    }

    companion object {
        /**
         * Main.
         *
         * @param args args
         */
        @JvmStatic fun main(args: Array<String>) {
            LambdaExamples().showLambdaFunctions()
        }
    }
}
