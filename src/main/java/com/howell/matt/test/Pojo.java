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
public class Pojo {

    /** Player. */
    Player player;

    /** String. */
    String aString;

    /** Boolean. */
    boolean aBool;

    /** Integer. */
    int anInt;
}


