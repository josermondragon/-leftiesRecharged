package com.maledictus;

import com.maledictus.item.Item;
import com.maledictus.item.ItemType;
import com.maledictus.npc.NPC;
import com.maledictus.player.Player;

import java.util.Map;

import static com.maledictus.Input.scannerUserInput;

public class Battle {

    private final Player player;
    private final NPC npc;
    private boolean combat = true;

     public Battle(Player player, NPC npc) {
        this.player = player;
        this.npc = npc;
    }

    public void start() {
       while(combat && player.getHitPoints() > 0 && npc.getHitPoints() > 0) {
           // displayInventory();
           String userCommand = scannerUserInput();
           battleRound(userCommand);
       }
    }

    public void battleRound(String userCommand) {
        if (userCommand.equalsIgnoreCase("attack")) {
            player.attack(npc);
            npc.attack(player);
        } else if (userCommand.equalsIgnoreCase("run")) {
            this.player.setHitPoints(0);
            Printer.print("You attempt to run away.....");
        } else if (userCommand.equalsIgnoreCase("equip")) {
            Printer.print("CURRENT ITEMS");
            Printer.print("-------------");
            for (Map.Entry<String, Item> item : player.getInventory().entrySet()) {
                Printer.print(item.getKey());
            }
            String itemSelect = scannerUserInput();
            Printer.print("You equipped " + itemSelect);
            player.equipWeapon();
        }
    }

    public boolean isCombat() {
        return combat;
    }

    public void setCombat(boolean combat) {
        this.combat = combat;
    }
}