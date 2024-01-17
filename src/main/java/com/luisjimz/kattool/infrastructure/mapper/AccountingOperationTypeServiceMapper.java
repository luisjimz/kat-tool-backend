package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationTypeEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationStatusEntity;
import com.luisjimz.kattool.domain.model.AccountingOperationTypeModel;
import com.luisjimz.kattool.domain.model.AccountingOperationStatusModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AccountingOperationTypeServiceMapper extends ServiceMapper<AccountingOperationTypeEntity, AccountingOperationTypeModel> {

    AccountingOperationStatusServiceMapper ACCOUNTING_OPERATION_STATUS_SERVICE_MAPPER =
            Mappers.getMapper(AccountingOperationStatusServiceMapper.class);
    @Override
    @Mapping(target = "statuses", source = "statuses", qualifiedByName = "accountingOperationStatuses")
    AccountingOperationTypeModel toModel(AccountingOperationTypeEntity entity);

    @Named("accountingOperationStatuses")
    default List<AccountingOperationStatusModel> reportsStatuses(List<AccountingOperationStatusEntity> entities) {
        if(entities == null || entities.isEmpty()) return Collections.emptyList();
        return entities.stream().map(ACCOUNTING_OPERATION_STATUS_SERVICE_MAPPER::toModel).collect(Collectors.toList());
    }
}
