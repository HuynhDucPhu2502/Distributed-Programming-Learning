package iuh.fit.models;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Admin 2/8/2025
 **/
@RequiredArgsConstructor
@ToString
public enum EmployeeStatus {
    FULL_TIME("Full Time"),
    PART_TIME("Part Time"),
    CONTRACT("Contract");

    private final String displayName;

    @Override
    public String toString() {
        return displayName;
    }
}
