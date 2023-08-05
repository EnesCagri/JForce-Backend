package dev.enescagri.jforceapp.enum_converter;

import dev.enescagri.jforceapp.enums.InventoryStatus;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class InventoryStatusConverter extends GenericConverter<InventoryStatus> {

    @Override
    protected Class<InventoryStatus> getEnumClass() {
        return InventoryStatus.class;
    }
}