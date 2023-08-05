package dev.enescagri.jforceapp.enums;

import dev.enescagri.jforceapp.enum_converter.DisplayNameEnum;

public enum InventoryType implements DisplayNameEnum {
    CAR("Araba"),
    MOUSE("Fare"),
    KEYBOARD("Klavye"),
    DISK("Disk"),
    MONITOR("Monitör");

    private final String label;

    InventoryType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
