package com.template.data.repository;

import com.template.data.entity.MeteorologicalDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeteorologicalDataRepository extends JpaRepository<MeteorologicalDataEntity, Long> {
}
