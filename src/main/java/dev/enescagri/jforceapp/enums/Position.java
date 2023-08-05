package dev.enescagri.jforceapp.enums;

import dev.enescagri.jforceapp.enum_converter.DisplayNameEnum;

public enum Position implements DisplayNameEnum {
    DEVELOPER("Yazılım Geliştirme Uzmanı"),
    ASSISTANT("Yönetici Asitanı"),
    CHIEF("Yönetici");

    private final String label;

    Position(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
