package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.*;
import com.luisjimz.kattool.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountingOperationServiceMapper extends ServiceMapper<AccountingOperationEntity, AccountingOperationModel> {
    AccountingOperationStatusServiceMapper ACCOUNTING_OPERATION_STATUS_SERVICE_MAPPER =
            Mappers.getMapper(AccountingOperationStatusServiceMapper.class);
    AccountingOperationTypeServiceMapper ACCOUNTING_OPERATION_TYPE_SERVICE_MAPPER =
            Mappers.getMapper(AccountingOperationTypeServiceMapper.class);

    @Override
    @Mapping(target = "accountingOperationType", source = "accountingOperationType", qualifiedByName = "accountingOperationEntityToModel")
    @Mapping(target = "latestStatus", source = "latestStatus", qualifiedByName = "latestReportStatus")
    AccountingOperationModel toModel(AccountingOperationEntity entity);

    @Override
    @Mapping(target = "accountingOperationType", source = "accountingOperationType", qualifiedByName = "accountingOperationModelToEntity")
    AccountingOperationEntity toEntity(AccountingOperationModel dto);

    @Named("accountingOperationModelToEntity")
    default AccountingOperationTypeEntity accountingOperationModelToEntity(AccountingOperationTypeModel model) {
        AccountingOperationTypeEntity accountingOperationTypeEntity = new AccountingOperationTypeEntity();
        accountingOperationTypeEntity.setId(model.getId());
        return accountingOperationTypeEntity;
    }

    @Named("accountingOperationEntityToModel")
    default AccountingOperationTypeModel reportType(AccountingOperationTypeEntity entity) {
        return ACCOUNTING_OPERATION_TYPE_SERVICE_MAPPER.toModel(entity);
    }

    @Named("latestReportStatus")
    default AccountingOperationStatusModel latestReportStatus(AccountingOperationStatusEntity entity) {
        return ACCOUNTING_OPERATION_STATUS_SERVICE_MAPPER.toModel(entity);
    }
}
