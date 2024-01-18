package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.domain.model.AccountingOperationTypeModel;
import com.luisjimz.kattool.domain.model.ClientModel;
import com.luisjimz.kattool.domain.model.UserModel;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationTypeEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.ClientEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClientServiceMapper extends ServiceMapper<ClientEntity, ClientModel> {

    AccountingOperationTypeServiceMapper ACCOUNTING_OPERATION_TYPE_SERVICE_MAPPER =
            Mappers.getMapper(AccountingOperationTypeServiceMapper.class);

    UserServiceMapper USER_SERVICE_MAPPER =
            Mappers.getMapper(UserServiceMapper.class);

    @Override
    @Mapping(source = "operationTypes", target = "enabledOperations", qualifiedByName = "toOperationTypeModel")
    @Mapping(source = "assignedAccountant", target = "assignedAccountant", qualifiedByName = "toUserModel")
    ClientModel toModel(ClientEntity entity);

    @Override
    @Mapping(source = "enabledOperations", target = "operationTypes", qualifiedByName = "toOperationTypeEntity")
    ClientEntity toEntity(ClientModel model);

    @Named("toOperationTypeModel")
    default List<AccountingOperationTypeModel> toOperationTypeModel(List<AccountingOperationTypeEntity> entities) {
       return entities != null
               ? entities.stream().map(ACCOUNTING_OPERATION_TYPE_SERVICE_MAPPER::toModel).collect(Collectors.toList())
               : Collections.emptyList();
    }

    @Named("toOperationTypeEntity")
    default List<AccountingOperationTypeEntity> toOperationTypeEntity(List<AccountingOperationTypeModel> models) {
        return models.stream()
                .map(model -> new AccountingOperationTypeEntity(model.getId())).collect(Collectors.toList());
    }

    @Named("toUserModel")
    default UserModel toUserModel(UserEntity entity) {
        return USER_SERVICE_MAPPER.toModel(entity);
    }

}
