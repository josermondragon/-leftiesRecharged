package com.maledictus.item.weapon;

import com.maledictus.Printer;
import com.maledictus.item.Item;
import com.maledictus.item.ItemType;

public class Weapon extends Item {

    private WeaponType weaponType;

    public Weapon(String name, String description, ItemType itemType, WeaponType weaponType) {
        super(name, description, itemType);
        this.weaponType = weaponType;
    }

    public void use() {
        Printer.print("You used your weapon");
    }
}