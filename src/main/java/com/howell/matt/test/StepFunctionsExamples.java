package com.howell.matt.test;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.stepfunctions.AWSStepFunctions;
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClientBuilder;
import com.amazonaws.services.stepfunctions.model.ListStateMachinesRequest;
import com.amazonaws.services.stepfunctions.model.StartExecutionRequest;
import com.amazonaws.services.stepfunctions.model.StartExecutionResult;
import com.amazonaws.services.stepfunctions.model.StateMachineListItem;

import lombok.extern.slf4j.Slf4j;

/**
 * Step Functions.
 */
@Slf4j
public class StepFunctionsExamples {

    /**
     * Get step functions client.
     *
     * @return AWSStepFunctions
     */
    public static AWSStepFunctions awsStepFunctions() {
        return AWSStepFunctionsClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
    }

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final var examples = new StepFunctionsExamples();

        examples.startStateMachines();
        examples.showStateMachines();
    }

    /**
     * Show state machines.
     */
    public void showStateMachines() {
        final var stepFunctionsClient = awsStepFunctions();
        stepFunctionsClient.listStateMachines(new ListStateMachinesRequest()).getStateMachines().stream().map
            (StateMachineListItem::getStateMachineArn).forEach(log::info);
    }

    /**
     * Start state machines.
     */
    public void startStateMachines() {
        final var stepFunctionsClient = awsStepFunctions();

        final var result = stepFunctionsClient.startExecution(new StartExecutionRequest()
            .withStateMachineArn("arn:aws:states:us-west-2:707560230714:stateMachine:TestStateMachine-YFR96URIHFKM"));
        log.info(result.getExecutionArn());
    }
}
