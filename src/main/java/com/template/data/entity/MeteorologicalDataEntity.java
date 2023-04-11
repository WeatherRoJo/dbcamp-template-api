package com.template.data.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "meteorological_data")
public class MeteorologicalDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "city")
    private String city;

    @Column(name = "weather_date")
    private LocalDate weatherDate;

    //    @Enumerated(EnumType.STRING)
    @Column(name = "morning_weather")
    private String morningWeather;

    //    @Enumerated(EnumType.STRING)
    @Column(name = "night_weather")
    private String nightWeather;

    @Column(name = "max_temperature")
    private int maxTemperature;

    @Column(name = "min_temperature")
    private int minTemperature;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "precipitation")
    private int precipitation;

    @Column(name = "wind_speed")
    private int windSpeed;

    public MeteorologicalDataEntity(String city, LocalDate weatherDate, String morningWeather, String nightWeather,
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
