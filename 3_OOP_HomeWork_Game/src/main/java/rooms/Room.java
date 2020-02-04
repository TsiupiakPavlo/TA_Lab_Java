package rooms;

import characters.Monster;
import items.Chest;
import items.Key;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Point roomCoord;
    private Chest chest;
    private List<Monster> monsters;
    private Key key;

    public Room(String name, String description, Point roomCoord) {
        this(name, description, roomCoord, null, new ArrayList<Monster>());
    }

    public Room(String name, String description, Point roomCoord, Chest chest, List<Monster> monsters) {
        super();
        this.name = name;
        this.description = description;
        this.roomCoord = roomCoord;
        this.chest = chest;
        this.monsters = monsters;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Point getRoomCoord() {
        return roomCoord;
    }
    public void setRoomCoord(Point roomCoord) {
        this.roomCoord = roomCoord;
    }




    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void setMonster(Monster e) {
        monsters.add(e);
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void deleteMonsters(Monster monster) {
        monsters.remove(monster);
    }


    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", description=" + description + "]";
    }
}
