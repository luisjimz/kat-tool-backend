package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingReportEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AccountingReportRepository extends JpaRepository<AccountingReportEntity, Long> {
    Collection<AccountingReportEntity> findByYearAndMonth(int year, int month);
    Collection<AccountingReportEntity> findByYearAndMonthAndUserId(int year, int month, UserEntity userId);

}
