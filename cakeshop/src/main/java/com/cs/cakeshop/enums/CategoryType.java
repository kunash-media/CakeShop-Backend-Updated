package com.cs.cakeshop.enums;

public enum CategoryType {
    CAKE_TYPE("By Type"),
    OCCASION("By Occasion"),
    KIDS("Kids Cakes"),
    SPECIALTY("Specialty"),
    PASTRY_TYPE("Pastry Type"),
    FLAVOUR("By Flavours"),
    DIETARY("Dietary Options");

    private String displayName;

    CategoryType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
