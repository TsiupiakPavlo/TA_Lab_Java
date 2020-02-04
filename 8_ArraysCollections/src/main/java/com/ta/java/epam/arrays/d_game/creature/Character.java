package com.ta.java.epam.arrays.d_game.creature;

public class Character extends Creature {
    public Character() {
        super();
    }

    @Override
    public void setPower() {
        super.power = 25;
    }

    public void plusArtifactPower(int power) {
        super.power += power;
    }

    @Override
    public int getPower() {
        return super.getPower();
    }
}
