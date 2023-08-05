package dev.enescagri.jforceapp.enums;

import dev.enescagri.jforceapp.enum_converter.DisplayNameEnum;

public enum Department implements DisplayNameEnum {
    SOFTWARE("Yazılım Geliştirme"),
    ARGE("ARGE");

    private final String label;

    Department(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }


}
