package com.ta.java.epam.arrays.d_game.creature;

import java.util.Random;

public class Artifact extends Creature {
    public Artifact() {
        super();
    }

    @Override
    public void setPower() {
        super.power = new Random().nextInt(80 - 10) + 10;
    }
}
