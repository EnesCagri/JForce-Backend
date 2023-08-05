package dev.enescagri.jforceapp.enums;

import dev.enescagri.jforceapp.enum_converter.DisplayNameEnum;

public enum InventoryStatus implements DisplayNameEnum {
    DEPOT("Depoda"),
    USING("Personelde"),
    OFFICE("Ofiste");

    private final String label;

    InventoryStatus(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
