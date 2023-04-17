package com.template.data.dto;

import com.template.data.enums.WeatherEnum;

import java.time.LocalDate;

public record MeteorologicalDataDTO(String city,
                                    LocalDate weatherDate,
                                    WeatherEnum morningWeather,
                                    WeatherEnum nightWeather,
                                    Integer maxTemperature,
                                    Integer minTemperature,
                                    Integer humidity,
                                    Integer precipitation,
                                    Integer windSpeed
) {
}
