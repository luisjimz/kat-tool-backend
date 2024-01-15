package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.ReportStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportStatusRepository extends JpaRepository<ReportStatusEntity, Long> {
}
