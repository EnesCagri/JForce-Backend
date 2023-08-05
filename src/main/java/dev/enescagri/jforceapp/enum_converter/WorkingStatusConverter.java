package dev.enescagri.jforceapp.enum_converter;

import dev.enescagri.jforceapp.enums.WorkingStatus;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class WorkingStatusConverter extends GenericConverter<WorkingStatus> {
    @Override
    protected Class<WorkingStatus> getEnumClass() {
        return WorkingStatus.class;
    }
}
