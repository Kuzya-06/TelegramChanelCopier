package ru.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TimeFrame {

    TICK("TICK"),
    SEC_1("SEC_1"),
    SEC_5("SEC_5"),
    SEC_10("SEC_10"),
    SEC_15("SEC_15"),
    SEC_30("SEC_30"),
    MIN_1("MIN_1"),
    MIN_2("MIN_2"),
    MIN_3("MIN_3"),
    MIN_5("MIN_5"),
    MIN_10("MIN_10"),
    MIN_15("MIN_15"),
    MIN_20("MIN_20"),
    MIN_30("MIN_30"),
    HOUR_1("HOUR_1"),
    HOUR_2("HOUR_2"),
    HOUR_4("HOUR_4"),
    DAY_1("DAY_1"),
    WEEK_1("WEEK_1"),
    MONTH_1("MONTH_1");

    private final String description;

    @JsonValue
    public String getDescription() {
        return this.description;
    }

    TimeFrame(final String description) {
        this.description = description;
    }
}
