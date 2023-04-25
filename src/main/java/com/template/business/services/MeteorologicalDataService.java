package com.template.business.services;

import com.template.data.dto.MeteorologicalDataDTO;
import com.template.data.entity.MeteorologicalDataEntity;
import com.template.data.repository.MeteorologicalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class MeteorologicalDataService {

    @Autowired
    MeteorologicalDataRepository meteorologicalDataRepository;

    public Page<MeteorologicalDataEntity> getAll(Pageable pagination) {
        return meteorologicalDataRepository.findAll(pagination);
    }

    public Page<MeteorologicalDataEntity> getAllByCity(String city, Pageable pagination) {
        return meteorologicalDataRepository.findByCity(city, pagination);
    }

    public MeteorologicalDataEntity create(@RequestBody MeteorologicalDataDTO meteorologicalData) {
        return meteorologicalDataRepository.save(new MeteorologicalDataEntity(meteorologicalData.city(),
                meteorologicalData.weatherDate(),
                meteorologicalData.morningWeather(),
                meteorologicalData.nightWeather(),
                meteorologicalData.maxTemperature(),
                meteorologicalData.minTemperature(),
                meteorologicalData.humidity(),
                meteorologicalData.precipitation(),
                meteorologicalData.windSpeed()));
    }
}
