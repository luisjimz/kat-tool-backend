package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingReportEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AccountingReportRepository extends JpaRepository<AccountingReportEntity, Long> {

    Collection<AccountingReportEntity> findByYearAndUserId(Long year, UserEntity userId);
    Collection<AccountingReportEntity> findByYearAndMonth(Integer year, Integer month);
    Collection<AccountingReportEntity> findByYearAndMonthAndUserId(Integer year, Integer month, UserEntity userId);

    Collection<AccountingReportEntity> findByClientId(Long clientId);

    Collection<AccountingReportEntity> findByYear(Long year);
}
