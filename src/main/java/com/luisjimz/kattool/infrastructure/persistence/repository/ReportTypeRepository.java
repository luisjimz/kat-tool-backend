package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.ReportTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportTypeRepository extends JpaRepository<ReportTypeEntity, Long> {
}
