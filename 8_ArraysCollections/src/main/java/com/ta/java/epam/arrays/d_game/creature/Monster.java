package com.ta.java.epam.arrays.d_game.creature;

import java.util.Random;

public class Monster extends Creature {
    public Monster() {
        super();
    }

    @Override
    public void setPower() {
        super.power = new Random().nextInt(100 - 5) + 5;
    }
}
