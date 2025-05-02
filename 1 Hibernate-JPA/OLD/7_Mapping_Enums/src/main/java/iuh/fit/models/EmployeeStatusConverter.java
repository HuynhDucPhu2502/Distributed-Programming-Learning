package iuh.fit.models;

import jakarta.persistence.AttributeConverter;

/**
 * Admin 2/8/2025
 **/
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, String> {
    @Override
    public String convertToDatabaseColumn(EmployeeStatus employeeStatus) {
        if (employeeStatus == null) return null;
        else {
            switch (employeeStatus) {
                case FULL_TIME:
                    return "Toàn thời gian";
                case PART_TIME:
                    return "Bán thời gian";
                case CONTRACT:
                    return "Hợp đồng";
                default:
                    throw new IllegalArgumentException("Unexpected enum value: " + employeeStatus);
            }
        }
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(String s) {
        if (s == null) return null;
        else {
            switch (s) {
                case "Toàn thời gian":
                    return EmployeeStatus.FULL_TIME;
                case "Bán thời gian":
                    return EmployeeStatus.PART_TIME;
                case "Hợp đồng":
                    return EmployeeStatus.CONTRACT;
                default:
                    throw new IllegalArgumentException("Unexpected enum value: " + s);
            }
        }
    }
}
