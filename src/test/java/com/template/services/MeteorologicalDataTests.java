package com.template.services;

import com.template.business.services.MeteorologicalDataService;
import com.template.data.dto.MeteorologicalDataDTO;
import com.template.data.entity.MeteorologicalDataEntity;
import com.template.data.enums.WeatherEnum;
import com.template.data.repository.MeteorologicalDataRepository;
import com.template.presentation.controller.MeteorologicalDataController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("MeteorologicalData Service Tests")
public class MeteorologicalDataTests {

    @Mock
    MeteorologicalDataRepository meteorologicalDataRepository;

    @InjectMocks
    private MeteorologicalDataService meteorologicalDataService;


    MeteorologicalDataEntity meteorologicalData = MeteorologicalDataEntity.builder()
            .id(5)
            .city("Porto Alegre")
            .weatherDate(LocalDate.of(2023, 4, 12))
            .maxTemperature(32)
            .minTemperature(19)
            .morningWeather(WeatherEnum.SUN)
            .nightWeather(WeatherEnum.CLOUDY)
            .humidity(12)
            .precipitation(10)
            .windSpeed(11)
            .build();

    MeteorologicalDataEntity meteorologicalDataSemID = MeteorologicalDataEntity.builder()
            .city("Porto Alegre")
            .weatherDate(LocalDate.of(2023, 4, 12))
            .maxTemperature(32)
            .minTemperature(19)
            .morningWeather(WeatherEnum.SUN)
            .nightWeather(WeatherEnum.CLOUDY)
            .humidity(12)
            .precipitation(10)
            .windSpeed(11)
            .build();

    MeteorologicalDataDTO meteorologicalDataDTO = new MeteorologicalDataDTO("Porto Alegre",
            LocalDate.of(2023, 4, 12),
            WeatherEnum.SUN, WeatherEnum.CLOUDY, 32, 19, 12, 10, 11);

    @Test
    @DisplayName("POST - Success")
    void createSucess() {
        MeteorologicalDataEntity newMeteorologicalData = meteorologicalDataService.create(meteorologicalDataDTO);
        assertNotNull(newMeteorologicalData);
        System.out.println(meteorologicalDataDTO.city());
        System.out.println("DATA: " + newMeteorologicalData);
    }
}
