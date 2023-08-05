package dev.enescagri.jforceapp.enum_converter;

import dev.enescagri.jforceapp.enums.InventoryType;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class InventoryTypeConverter extends GenericConverter<InventoryType> {

    @Override
    protected Class<InventoryType> getEnumClass() {
        return InventoryType.class;
    }
}
