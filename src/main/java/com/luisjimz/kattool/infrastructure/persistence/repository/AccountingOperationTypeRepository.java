package com.luisjimz.kattool.infrastructure.persistence.repository;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingOperationTypeRepository extends JpaRepository<AccountingOperationTypeEntity, Long> {
}
