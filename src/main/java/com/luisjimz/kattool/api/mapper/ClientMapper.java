package com.luisjimz.kattool.api.mapper;

import com.luisjimz.kattool.api.http.ClientCreateHttpRequest;
import com.luisjimz.kattool.domain.model.AccountingOperationTypeModel;
import com.luisjimz.kattool.domain.model.ClientModel;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "operations", source = "operations", qualifiedByName = "toOperationsEntity")
    ClientModel toModel(ClientCreateHttpRequest httpRequest);

    @Named("toOperationsEntity")
    default List<AccountingOperationTypeModel> toOperationsEntity(List<Long> operations) {
        List<AccountingOperationTypeModel> models= operations.stream().map(id -> new AccountingOperationTypeModel(id)).collect(Collectors.toList());
        return models;
    }
}
