package dev.enescagri.jforceapp.enums;

import dev.enescagri.jforceapp.enum_converter.DisplayNameEnum;

public enum GraduationStatus implements DisplayNameEnum {
    ASSOCIATE("Ön lisans"),
    BACHELOR("Lisans"),
    GRADUATE("Yüksek lisans"),
    DOCTORATE("Doktora");
    private final String label;

    GraduationStatus(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
