package dev.enescagri.jforceapp.enums;

import dev.enescagri.jforceapp.enum_converter.DisplayNameEnum;

public enum Gender implements DisplayNameEnum {
    MALE("Erkek"),
    FEMALE("Kadın");

    private final String label;

    Gender(String label) {
        this.label = label;
    }
    @Override
    public String getLabel() {
        return label;
    }

}
