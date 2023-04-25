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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayName("MeteorologicalData Service Tests")
public class MeteorologicalDataTests {

    @Mock
    MeteorologicalDataRepository meteorologicalDataRepositoryMock;

    @InjectMocks
    private MeteorologicalDataService meteorologicalDataService;

    MeteorologicalDataDTO meteorologicalDataDTO = new MeteorologicalDataDTO("Porto Alegre",
            LocalDate.of(2023, 4, 12),
            WeatherEnum.SUN, WeatherEnum.CLOUDY, 32, 19, 12, 10, 11);

    MeteorologicalDataEntity meteorologicalData = new MeteorologicalDataEntity("Porto Alegre",
            LocalDate.of(2023, 4, 12),
            WeatherEnum.SUN, WeatherEnum.CLOUDY, 32, 19, 12, 10, 11);

    MeteorologicalDataEntity meteorologicalDataCity = new MeteorologicalDataEntity("Porto Alegre",
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
        when(meteorologicalDataRepositoryMock.save(any())).thenReturn(meteorologicalData);

        MeteorologicalDataEntity newMeteorologicalData = meteorologicalDataService.create(meteorologicalDataDTO);
        assertNotNull(newMeteorologicalData);
        verify(meteorologicalDataRepositoryMock).save(any());
    }

    @Test
    @DisplayName("POST - Error")
    void createError() {
        when(meteorologicalDataRepositoryMock.save(any())).thenReturn(meteorologicalDataInvalid);

        MeteorologicalDataEntity newMeteorologicalData = meteorologicalDataService.create(meteorologicalDataDTOInvalid);
        assertNull(newMeteorologicalData.getCity());
        verify(meteorologicalDataRepositoryMock).save(any());
    }

    @Test
    @DisplayName("GET - Success")
    void getAll() {
        Pageable pagination = mock(Pageable.class);
        List<MeteorologicalDataEntity> meteorologicalDataList = List.of(meteorologicalData);
        Page<MeteorologicalDataEntity> page = new PageImpl<>(meteorologicalDataList);
        when(meteorologicalDataRepositoryMock.findAll(any(Pageable.class))).thenReturn(page);

        Page<MeteorologicalDataEntity> response = meteorologicalDataService.getAll(pagination);

        assertNotNull(response);
        assertEquals(meteorologicalDataList, response.getContent());
        assertEquals(1, response.getTotalElements());
    }


    @Test
    @DisplayName("GET by city name - Success")
    void getByCityName() {
        Pageable pagination = mock(Pageable.class);
        List<MeteorologicalDataEntity> meteorologicalDataList = List.of(meteorologicalData, meteorologicalDataCity);
        Page<MeteorologicalDataEntity> page = new PageImpl<>(meteorologicalDataList);
        when(meteorologicalDataRepositoryMock.findByCity(anyString(), any(Pageable.class))).thenReturn(page);

        Page<MeteorologicalDataEntity> response = meteorologicalDataService.getAllByCity("Porto Alegre", pagination);
        assertNotNull(response);
        assertEquals(meteorologicalDataList, response.getContent());
        assertEquals(2, response.getTotalElements());
    }

    @Test
    @DisplayName("GET by city name - No elements found")
    void getByCityNameNoContent() {
        Pageable pagination = mock(Pageable.class);
        Page<MeteorologicalDataEntity> page = mock(Page.class);
        when(meteorologicalDataRepositoryMock.findByCity(anyString(), any(Pageable.class))).thenReturn(page);

        Page<MeteorologicalDataEntity> response = meteorologicalDataService.getAllByCity("São Paulo", pagination);
        assertNotNull(response);
        assertEquals(0, response.getTotalElements());
    }
}
