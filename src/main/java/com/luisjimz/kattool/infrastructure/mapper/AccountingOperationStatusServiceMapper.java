package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationStatusEntity;
import com.luisjimz.kattool.model.AccountingOperationStatusModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountingOperationStatusServiceMapper extends ServiceMapper <AccountingOperationStatusEntity, AccountingOperationStatusModel> {
}
