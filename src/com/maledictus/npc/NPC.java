package com.maledictus.npc;

import com.maledictus.Printer;
import com.maledictus.player.Player;

public class NPC {

    int id;
    int hitPoints;
    String name;
    String description;
    boolean isHostile;
    Species species;

    public NPC(int id, int hitPoints, String name, String description, boolean isHostile, Species species) {
        this.id = id;
        this.hitPoints = hitPoints;
        this.name = name;
        this.description = description;
        this.isHostile = isHostile;
        this.species = species;
    }

    public int attack(Player player) {
        Printer.print("Player hit points is " + player.getHitPoints());
        player.setHitPoints(player.getHitPoints() - 8);
        Printer.print("Player hit points is " + player.getHitPoints());
        return player.getHitPoints();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public boolean getIsHostile() {
        return isHostile;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "id=" + id +
                ", hitPoints=" + hitPoints +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isHostile=" + isHostile +
                ", species=" + species +
                '}';
    }
}