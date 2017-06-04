package com.howell.matt.test;

import com.howell.matt.model.Player;

import lombok.Builder;
import lombok.Data;

/**
 * Test POJO.
 */
@Builder
@Data
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class TestPojo {

    /**
     * Player.
     */
    private Player player;

    /**
     * String.
     */
    private String aString;

    /**
     * Boolean.
     */
    private boolean aBool;

    /**
     * Integer.
     */
    private int anInt;
}


