package com.howell.matt.kotlin.test

import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQSClientBuilder

/**
 * SQS examples.
 */
class SqsExamples {

    val log = loggerFor(::SqsExamples.javaClass)

    /**
     * Show SQS queues.
     */
    fun showQueues() {
        val sqsClient = AmazonSQSClientBuilder.standard().withRegion(Regions.US_WEST_2).build()
        sqsClient.listQueues().queueUrls.forEach({ log.info(it) })
    }

    companion object {

        /**
         * Main.

         * @param args args
         */
        @JvmStatic fun main(args: Array<String>) {
            SqsExamples().showQueues()
        }
    }
}
