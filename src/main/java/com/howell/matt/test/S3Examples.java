package com.howell.matt.test;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import lombok.extern.slf4j.Slf4j;

/**
 * S3 examples.
 */
@Slf4j
public class S3Examples {

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new S3Examples().showS3Buckets();
    }

    /**
     * Show S3 buckets.
     */
    public void showS3Buckets() {
        final var s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        s3Client.listBuckets().stream().map(Bucket::getName).forEach(log::info);
    }
}
