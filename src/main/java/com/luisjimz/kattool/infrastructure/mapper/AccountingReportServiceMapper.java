package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.domain.model.*;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingReportEntity;
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
public interface AccountingReportServiceMapper extends ServiceMapper<AccountingReportEntity, AccountingReportModel> {

    ClientServiceMapper CLIENT_SERVICE_MAPPER = Mappers.getMapper(ClientServiceMapper.class);
    UserServiceMapper USER_SERVICE_MAPPER = Mappers.getMapper(UserServiceMapper.class);

    AccountingOperationStatusServiceMapper ACCOUNTING_OPERATION_STATUS_SERVICE_MAPPER
            = Mappers.getMapper(AccountingOperationStatusServiceMapper.class);
    AccountingOperationTypeServiceMapper ACCOUNTING_OPERATION_TYPE_SERVICE_MAPPER
            = Mappers.getMapper(AccountingOperationTypeServiceMapper.class);


    @Override
    @Mapping(target = "client", source = "client", qualifiedByName = "clientModelToClientEntity")
    @Mapping(target = "assignedUser", source = "assignedUser", qualifiedByName = "userModelToUserEntity")
    AccountingReportEntity toEntity(AccountingReportModel model);

    @Override
    @Mapping(target = "client", source = "client", qualifiedByName = "clientEntityToClientModel")
    @Mapping(target = "assignedUser", source = "assignedUser", qualifiedByName = "userEntityToUserModel")
    @Mapping(target = "relatedOperations", source = "relatedOperations", qualifiedByName = "operationEntityToModel")
    AccountingReportModel toModel(AccountingReportEntity entity);

    @Named("clientModelToClientEntity")
    default ClientEntity clientModelToClientEntity(ClientModel model) {
        ClientEntity entity = new ClientEntity();
        entity.setId(model.getId());
        return entity;
    }

    @Named("clientEntityToClientModel")
    default ClientModel clientEntityToClientModel(ClientEntity entity) {
        return CLIENT_SERVICE_MAPPER.toModel(entity);
    }

    @Named("userModelToUserEntity")
    default UserEntity userModelToUserEntity(UserModel model) {
        UserEntity entity = new UserEntity();
        entity.setId(model.getId());
        return entity;
    }

    @Named("userEntityToUserModel")
    default UserModel userEntityToUserModel(UserEntity entity) {
        return USER_SERVICE_MAPPER.toModel(entity);
    }

    @Named("operationEntityToModel")
    default List<AccountingOperationModel> operationEntityToModel(List<AccountingOperationEntity> entities) {
        if(entities == null || entities.isEmpty()) return Collections.emptyList();
        return entities.stream().map(entity -> new AccountingOperationModel(
                entity.getId(),
                null,
                ACCOUNTING_OPERATION_TYPE_SERVICE_MAPPER.toModel(entity.getAccountingOperationType()),
                ACCOUNTING_OPERATION_STATUS_SERVICE_MAPPER.toModel(entity.getLatestStatus()),
                entity.getCreationDate()
        )).collect(Collectors.toList());
    }
}
