package com.template.data.entity;

import com.template.data.enums.WeatherEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "meteorological_data")
public class MeteorologicalDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Column(name = "city")
    private String city;

    @Column(name = "weather_date")
    private LocalDate weatherDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "morning_weather")
    private WeatherEnum morningWeather;

    @Enumerated(EnumType.STRING)
    @Column(name = "night_weather")
    private WeatherEnum nightWeather;

    @Column(name = "max_temperature")
    private Integer maxTemperature;

    @Column(name = "min_temperature")
    private int minTemperature;

    @Column(name = "humidity")
    private Integer humidity;

    @Column(name = "precipitation")
    private Integer precipitation;

    @Column(name = "wind_speed")
    private Integer windSpeed;

    public MeteorologicalDataEntity(String city, LocalDate weatherDate, WeatherEnum morningWeather, WeatherEnum nightWeather,
                                    int maxTemperature, int minTemperature, int humidity, int precipitation, int windSpeed) {
        this.city = city;
        this.weatherDate = weatherDate;
        this.morningWeather = morningWeather;
        this.nightWeather = nightWeather;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.windSpeed = windSpeed;
    }

}
