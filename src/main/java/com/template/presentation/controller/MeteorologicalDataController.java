package com.template.presentation.controller;

import com.template.business.services.MeteorologicalDataService;
import com.template.data.dto.MeteorologicalDataDTO;
import com.template.data.entity.MeteorologicalDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4767")
@RestController
@RequestMapping("/meteorologicalData")
public class MeteorologicalDataController {

    @Autowired
    MeteorologicalDataService meteorologicalDataService;

    @GetMapping
    public ResponseEntity<Page<MeteorologicalDataEntity>> getAllMeteorologicalData(@PageableDefault(size = 10, sort = {"weatherDate"}, direction = Sort.Direction.DESC) Pageable pagination) {
        try {
            Page<MeteorologicalDataEntity> meteorologicalData = meteorologicalDataService.getAll(pagination);
            if (meteorologicalData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(meteorologicalData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{city}")
    public ResponseEntity<Page<MeteorologicalDataEntity>> getMeteorologicalDataByCity(@PathVariable("city") String city,
                                                                                      @PageableDefault(size = 10, sort = {"weatherDate"}, direction = Sort.Direction.DESC) Pageable pagination) {
        try {
            Page<MeteorologicalDataEntity> meteorologicalData = meteorologicalDataService.getAllByCity(city, pagination);
            if (meteorologicalData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(meteorologicalData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<MeteorologicalDataEntity> createMeteorologicalData(@RequestBody MeteorologicalDataDTO meteorologicalDataDTO) {
        try {
            MeteorologicalDataEntity _meteorologicalData = meteorologicalDataService.create(meteorologicalDataDTO);
            return new ResponseEntity<MeteorologicalDataEntity>(_meteorologicalData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
