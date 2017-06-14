package com.howell.matt.kotlin.test

import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder

/**
 * S3 examples.
 */
class S3Examples {

    val log = loggerFor(::S3Examples.javaClass)

    /**
     * Show S3 buckets.
     */
    fun showS3Buckets() {
        val s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_WEST_2).build()
        s3Client.listBuckets().stream().map({ it.getName() }).forEach({ log.info(it) })
    }

    companion object {

        /**
         * Main.

         * @param args args
         */
        @JvmStatic fun main(args: Array<String>) {
            S3Examples().showS3Buckets()
        }
    }
}
