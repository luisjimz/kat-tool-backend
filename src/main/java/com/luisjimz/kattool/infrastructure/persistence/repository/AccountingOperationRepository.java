package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface AccountingOperationRepository extends JpaRepository<AccountingOperationEntity, Long> {
    Collection<AccountingOperationEntity> findByUserId(Long id);
    Collection<AccountingOperationEntity> findByClientId(Long clientId);
    Collection<AccountingOperationEntity> findByYearAndMonth(int year, int month);

}
