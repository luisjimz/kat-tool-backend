package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.UUID;

public interface ReportRepository extends JpaRepository<ReportEntity, UUID> {
    Collection<ReportEntity> findByUserId(Long id);
}
