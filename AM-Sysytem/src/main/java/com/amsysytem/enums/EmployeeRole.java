package com.amsysytem.enums;

import lombok.Getter;

@Getter
public enum EmployeeRole {

    ADMIN("ADMIN"),
    USER("USER"),
    MANAGER("MANAGER");

    private final String displayText;

    EmployeeRole(String displayText) {
        this.displayText = displayText;
    }

}
