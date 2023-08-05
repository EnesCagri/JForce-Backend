package dev.enescagri.jforceapp.enum_converter;

import dev.enescagri.jforceapp.enums.Department;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DepartmentConverter extends GenericConverter<Department>{
    @Override
    protected Class<Department> getEnumClass() {
        return Department.class;
    }
}
