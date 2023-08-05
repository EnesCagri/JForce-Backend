package dev.enescagri.jforceapp.enums;

import dev.enescagri.jforceapp.enum_converter.DisplayNameEnum;

public enum MartialStatus implements DisplayNameEnum {
    SINGLE("Bekar"),
    MARRIED("Evli");

    private final String label;

    MartialStatus(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
