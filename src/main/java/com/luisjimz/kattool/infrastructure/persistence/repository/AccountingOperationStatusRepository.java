package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingOperationStatusRepository extends JpaRepository<AccountingOperationStatusEntity, Long> {
}
