package com.howell.matt.test;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * SQS examples.
 */
@Slf4j
public class SqsExamples {

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new SqsExamples().showQueues();
    }

    /**
     * Show SQS queues.
     */
    public void showQueues() {
        final var sqsClient = AmazonSQSClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        sqsClient.listQueues().getQueueUrls().forEach(log::info);
    }
}
