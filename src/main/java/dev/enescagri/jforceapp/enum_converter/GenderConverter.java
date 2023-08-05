package dev.enescagri.jforceapp.enum_converter;

import dev.enescagri.jforceapp.enums.Gender;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter extends GenericConverter<Gender>{
    @Override
    protected Class<Gender> getEnumClass() {
        return Gender.class;
    }
}
