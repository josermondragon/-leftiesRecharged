package com.maledictus.item.key;

import com.maledictus.Printer;
import com.maledictus.item.Item;
import com.maledictus.item.ItemType;

public class Key extends Item {

    private KeyType keyType;

    public Key (String name, String description, ItemType itemType, KeyType keyType) {
        super(name, description, itemType);
        this.keyType = keyType;
    }

    public KeyType getKeyType() {
        return keyType;
    }

    public void use() {
        Printer.print("You used your Key!");
    }
}