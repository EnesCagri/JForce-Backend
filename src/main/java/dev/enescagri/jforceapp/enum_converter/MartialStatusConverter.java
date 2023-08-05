package dev.enescagri.jforceapp.enum_converter;

import dev.enescagri.jforceapp.enums.MartialStatus;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MartialStatusConverter extends GenericConverter<MartialStatus> {
    @Override
    protected Class<MartialStatus> getEnumClass() {
        return MartialStatus.class;
    }
}
