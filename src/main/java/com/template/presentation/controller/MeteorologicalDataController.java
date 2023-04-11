package com.template.presentation.controller;

import com.template.business.services.MeteorologicalDataService;
import com.template.data.entity.MeteorologicalDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4767")
@RestController
@RequestMapping("/meteorologicalData")
public class MeteorologicalDataController {

    @Autowired
    MeteorologicalDataService meteorologicalDataService;

    @PostMapping
    public ResponseEntity<MeteorologicalDataEntity> createMeteorologicalData(@RequestBody MeteorologicalDataEntity meteorologicalData) {
        try {
            MeteorologicalDataEntity _meteorologicalData = meteorologicalDataService.create(new MeteorologicalDataEntity(meteorologicalData.getCity(),
                    meteorologicalData.getWeatherDate(),
                    meteorologicalData.getMorningWeather(),
                    meteorologicalData.getNightWeather(),
                    meteorologicalData.getMaxTemperature(),
                    meteorologicalData.getMinTemperature(),
                    meteorologicalData.getHumidity(),
                    meteorologicalData.getPrecipitation(),
                    meteorologicalData.getWindSpeed()));
            return new ResponseEntity<>(_meteorologicalData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
