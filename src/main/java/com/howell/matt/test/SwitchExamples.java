package com.howell.matt.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SwitchExamples {

    private SwitchExamples() {
    }

    public void run() {
        final var direction = Direction.EAST;

        final var translated = switch (direction) {
            case NORTH -> "up";
            case EAST -> "right";
            case SOUTH -> "down";
            case WEST -> "left";
        };

        System.out.println(translated);
    }

    public static void main(String[] args) {
        final var switchExamples = new SwitchExamples();
        switchExamples.run();
    }
}
