package com.template.data.repository;

import com.template.data.entity.MeteorologicalDataEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeteorologicalDataRepository extends JpaRepository<MeteorologicalDataEntity, Long> {
    Page<MeteorologicalDataEntity> findByCity(String city, Pageable page);

}
