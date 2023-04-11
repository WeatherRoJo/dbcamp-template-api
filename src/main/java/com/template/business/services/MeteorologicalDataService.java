package com.template.business.services;

import com.template.data.entity.MeteorologicalDataEntity;
import com.template.data.repository.MeteorologicalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MeteorologicalDataService {

    @Autowired
    MeteorologicalDataRepository meteorologicalDataRepository;

    public MeteorologicalDataEntity create(@RequestBody MeteorologicalDataEntity meteorologicalData) {

        return meteorologicalDataRepository.save(new MeteorologicalDataEntity(meteorologicalData.getCity(),
                meteorologicalData.getWeatherDate(),
                meteorologicalData.getMorningWeather(),
                meteorologicalData.getNightWeather(),
                meteorologicalData.getMaxTemperature(),
                meteorologicalData.getMinTemperature(),
                meteorologicalData.getHumidity(),
                meteorologicalData.getPrecipitation(),
                meteorologicalData.getWindSpeed()));
    }


}
