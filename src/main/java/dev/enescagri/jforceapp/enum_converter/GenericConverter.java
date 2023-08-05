package dev.enescagri.jforceapp.enum_converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class GenericConverter<T extends Enum<T> & DisplayNameEnum> implements AttributeConverter<T, String>  {
    @Override
    public String convertToDatabaseColumn(T enumType) {
        return enumType.getLabel();
    }

    @Override
    public T convertToEntityAttribute(String label) {
        Class<T> enumClass = getEnumClass();
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getLabel().equals(label)) {
                return enumConstant;
            }
        }
        throw new IllegalArgumentException("Invalid type label: " + label);
    }

    protected Class<T> getEnumClass() {
        throw new UnsupportedOperationException("You must implement this method.");
    }
}
