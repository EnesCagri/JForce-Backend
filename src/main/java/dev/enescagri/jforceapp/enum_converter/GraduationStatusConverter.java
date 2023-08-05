package dev.enescagri.jforceapp.enum_converter;


import dev.enescagri.jforceapp.enums.GraduationStatus;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GraduationStatusConverter extends GenericConverter<GraduationStatus> {
    @Override
    protected Class<GraduationStatus> getEnumClass() {
        return GraduationStatus.class;
    }
}
