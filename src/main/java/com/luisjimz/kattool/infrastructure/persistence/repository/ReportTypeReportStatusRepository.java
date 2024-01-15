package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.ReportTypeReportStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportTypeReportStatusRepository extends JpaRepository<ReportTypeReportStatusEntity, Long> {
}
