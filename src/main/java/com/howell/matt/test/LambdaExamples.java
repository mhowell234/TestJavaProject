package com.howell.matt.test;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.FunctionConfiguration;

import lombok.extern.slf4j.Slf4j;

/**
 * Lambda examples.
 */
@Slf4j
public class LambdaExamples {

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new LambdaExamples().showLambdaFunctions();
    }

    /**
     * Show lambda functions.
     */
    public void showLambdaFunctions() {
        final AWSLambda lambdaClient = AWSLambdaClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        lambdaClient.listFunctions().getFunctions().stream().map(FunctionConfiguration::getFunctionName).forEach
            (log::info);
    }
}
