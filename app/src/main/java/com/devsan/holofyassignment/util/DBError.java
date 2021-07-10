package com.devsan.holofyassignment.util;

public enum DBError {

    EMPTY_LIST("No data found");

    private String displayName;

    DBError(String displayName) {

        this.displayName = displayName;
    }

    public String getName() {
        return displayName;
    }
}
