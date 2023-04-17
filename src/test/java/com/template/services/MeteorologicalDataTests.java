package com.template.services;

import com.template.business.services.MeteorologicalDataService;
import com.template.data.dto.MeteorologicalDataDTO;
import com.template.data.entity.MeteorologicalDataEntity;
import com.template.data.enums.WeatherEnum;
import com.template.data.repository.MeteorologicalDataRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("MeteorologicalData Service Tests")
public class MeteorologicalDataTests {

    @Mock
    MeteorologicalDataRepository meteorologicalDataRepository;

    @InjectMocks
    private MeteorologicalDataService meteorologicalDataService;

    MeteorologicalDataDTO meteorologicalDataDTO = new MeteorologicalDataDTO("Porto Alegre",
            LocalDate.of(2023, 4, 12),
            WeatherEnum.SUN, WeatherEnum.CLOUDY, 32, 19, 12, 10, 11);

    MeteorologicalDataEntity meteorologicalData = new MeteorologicalDataEntity("Porto Alegre",
            LocalDate.of(2023, 4, 12),
            WeatherEnum.SUN, WeatherEnum.CLOUDY, 32, 19, 12, 10, 11);

    MeteorologicalDataDTO meteorologicalDataDTOInvalid = new MeteorologicalDataDTO(null,
            LocalDate.of(2023, 4, 12),
            WeatherEnum.SUN, WeatherEnum.CLOUDY, 32, 19, 12, 10, 11);

    MeteorologicalDataEntity meteorologicalDataInvalid = new MeteorologicalDataEntity(null,
            LocalDate.of(2023, 4, 12),
            WeatherEnum.SUN, WeatherEnum.CLOUDY, 32, 19, 12, 10, 11);

    @Test
    @DisplayName("POST - Success")
    void createSucess() {
        when(meteorologicalDataRepository.save(any())).thenReturn(meteorologicalData);

        MeteorologicalDataEntity newMeteorologicalData = meteorologicalDataService.create(meteorologicalDataDTO);
        assertNotNull(newMeteorologicalData);
        verify(meteorologicalDataRepository).save(any());
    }

    @Test
    @DisplayName("POST - Error")
    void createError() {
        when(meteorologicalDataRepository.save(any())).thenReturn(meteorologicalDataInvalid);

        MeteorologicalDataEntity newMeteorologicalData = meteorologicalDataService.create(meteorologicalDataDTOInvalid);
        assertNull(newMeteorologicalData.getCity());
        verify(meteorologicalDataRepository).save(any());
    }
}
