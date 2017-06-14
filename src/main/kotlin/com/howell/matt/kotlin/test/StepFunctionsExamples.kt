package com.howell.matt.kotlin.test

import com.amazonaws.regions.Regions
import com.amazonaws.services.stepfunctions.AWSStepFunctions
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClientBuilder
import com.amazonaws.services.stepfunctions.model.ListStateMachinesRequest
import com.amazonaws.services.stepfunctions.model.StartExecutionRequest

/**
 * Step Functions.
 */
class StepFunctionsExamples(val awsStepFunctions: AWSStepFunctions) {

    val log = loggerFor(::StepFunctionsExamples.javaClass)

    /**
     * Show state machines.
     */
    fun showStateMachines() {
        awsStepFunctions.listStateMachines(ListStateMachinesRequest()).stateMachines.stream()
                .map({ it.getStateMachineArn() })
                .forEach({ log.info(it) })
    }

    /**
     * Start state machines.
     */
    fun startStateMachines() {
        val result = awsStepFunctions.startExecution(StartExecutionRequest()
                .withStateMachineArn("arn:aws:states:us-west-2:707560230714:stateMachine:TestStateMachine-YFR96URIHFKM"))
        log.info(result.executionArn)
    }

    companion object {

        /**
         * Get step functions client.

         * @return AWSStepFunctions
         */
        fun awsStepFunctions(): AWSStepFunctions {
            return AWSStepFunctionsClientBuilder.standard().withRegion(Regions.US_WEST_2).build()
        }

        /**
         * Main.

         * @param args args
         */
        @JvmStatic fun main(args: Array<String>) {
            val examples = StepFunctionsExamples(awsStepFunctions())

            examples.startStateMachines()
            examples.showStateMachines()
        }
    }
}
