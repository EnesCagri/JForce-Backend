package dev.enescagri.jforceapp.enums;

import dev.enescagri.jforceapp.enum_converter.DisplayNameEnum;

public enum WorkingStatus implements DisplayNameEnum {
    WORKING("Çalışıyor"),
    NOT_WORKING("Çalışmıyor");
    private final String label;

    WorkingStatus(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
