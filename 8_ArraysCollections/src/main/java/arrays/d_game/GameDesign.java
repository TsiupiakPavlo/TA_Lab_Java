package arrays.d_game;

import arrays.d_game.creature.Artifact;
import arrays.d_game.creature.Character;
import arrays.d_game.creature.Monster;

import java.util.Random;
import java.util.Scanner;

public class GameDesign {
    private Door[] generateDoors() {
        Door[] doors = new Door[10];
        for (int i = 0; i < doors.length; i++) {
            if (new Random().nextBoolean()) {
                doors[i] = new Door("Artifact", new Artifact().getPower());
            } else {
                doors[i] = new Door("Monster", new Monster().getPower());
            }
        }
        return doors;
    }

    private void printDoors(Door[] doors) {
        for (int i = 0; i < doors.length; i++) {
            System.out.println("Door number " + (i + 1) + " " + doors[i].toString());
        }
    }

    private int numberOfMonstersCanKill(Door[] doors, Character character) {
        int k = 0;
        for (Door door : doors) {
            if (door.getType().equals("Monster") && door.getPower() > character.getPower()) {
                k++;
            }
        }
        return k;
    }

    private boolean isAnyMonsterAlive(Door[] doors) {
        for (Door door : doors) {
            if (door.getType().equals("Monster")) {
                return true;
            }
        }
        return false;
    }

    public void startGame() {
        Door[] doors = generateDoors();
        Character character = new Character();
        printDoors(doors);
        System.out.println("Number of Monsters that can kill you" + numberOfMonstersCanKill(doors, character));
        Scanner scan = new Scanner(System.in);
        while (isAnyMonsterAlive(doors)) {
            System.out.println("Chose the door");
            int numberOfDoor = scan.nextInt() - 1;
            while ((numberOfDoor < 0) || (numberOfDoor > 9)) {
                System.out.println("Wrong input. Try again");
                numberOfDoor = scan.nextInt();
            }
            if (doors[numberOfDoor].getType().equals("Killed monster")) {
                System.out.println(doors[numberOfDoor].getType());
            }
            if (doors[numberOfDoor].getType().equals("Picked artifact")) {
                System.out.println(doors[numberOfDoor].getType());
            }
            if (doors[numberOfDoor].getType().equals("Monster")) {
                if (doors[numberOfDoor].getPower() > character.getPower()) {
                    System.out.println("You lose");
                    break;
                } else {
                    System.out.println("You kill monster");
                    doors[numberOfDoor].setType("Killed monster");
                }
            }
            if (doors[numberOfDoor].getType().equals("Artifact")) {
                character.plusArtifactPower(doors[numberOfDoor].getPower());
                System.out.println("Now power of your character is " + character.getPower());
                doors[numberOfDoor].setType("Picked artifact");
            }
        }
        if (!isAnyMonsterAlive(doors)) {
            System.out.println("Victory");
        }
    }

}
