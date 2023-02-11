package com.address_book.address.entity;

public enum RoleType {
    ADMIN("Administrator"),
    CLIENT("Client"),
    USER("User");

    public final String label;
    RoleType(String label) {
        this.label = label;
    }
}
