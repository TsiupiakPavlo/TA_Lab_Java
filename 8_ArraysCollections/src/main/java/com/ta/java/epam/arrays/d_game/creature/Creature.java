package com.ta.java.epam.arrays.d_game.creature;

abstract class Creature {
    public int power;

    public Creature() {
        setPower();
    }

    public void setPower() {
        this.power = 0;
    }

    public int getPower() {
        return power;
    }
}
