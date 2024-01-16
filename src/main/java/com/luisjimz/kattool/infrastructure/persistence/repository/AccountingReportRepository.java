package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingReportRepository extends JpaRepository<AccountingReportEntity, Long> {
}
