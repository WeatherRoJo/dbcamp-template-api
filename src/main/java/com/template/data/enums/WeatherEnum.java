package com.template.data.enums;

public enum WeatherEnum {
    RAIN("Chuva"),
    STORM("Tempestade"),
    SUN_WITH_CLOUDS("Sol com nuvens"),
    SUN("Sol"),
    CLOUDY("Nublado");

    private final String description;

    WeatherEnum(String description) {
        this.description = description;
    }
}
