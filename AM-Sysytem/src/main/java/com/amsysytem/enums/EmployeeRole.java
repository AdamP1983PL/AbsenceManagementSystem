package com.amsysytem.enums;

import lombok.Getter;

@Getter
public enum EmployeeRole {
    ADMIN("Admin"),
    USER("User"),
    MANAGER("Manager");

    private final String displayText;

    EmployeeRole(String displayText) {
        this.displayText = displayText;
    }
}
