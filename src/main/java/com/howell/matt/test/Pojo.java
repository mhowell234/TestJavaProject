package com.howell.test;

import com.howell.matt.model.Player;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Pojo {

    Player player;
    String aString;
    boolean aBool;
    int anInt;
}


