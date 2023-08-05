package dev.enescagri.jforceapp.enum_converter;

import dev.enescagri.jforceapp.enums.Position;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionConverter extends GenericConverter<Position>{
    @Override
    protected Class<Position> getEnumClass() {
        return Position.class;
    }
}
