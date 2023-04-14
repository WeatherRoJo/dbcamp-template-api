package com.template.data.dto;

import com.template.data.enums.WeatherEnum;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record MeteorologicalDataDTO(String city,
                                    LocalDate weatherDate,
                                    WeatherEnum morningWeather,
                                    WeatherEnum nightWeather,
                                    int maxTemperature,
                                    int minTemperature,
                                    int humidity,
                                    int precipitation,
                                    int windSpeed
) {
}
