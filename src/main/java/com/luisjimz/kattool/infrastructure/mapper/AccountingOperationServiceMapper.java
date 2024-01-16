package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.*;
import com.luisjimz.kattool.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountingOperationServiceMapper extends ServiceMapper<AccountingOperationEntity, AccountingOperationModel> {
    ClientServiceMapper CLIENT_SERVICE_MAPPER = Mappers.getMapper(ClientServiceMapper.class);
    UserServiceMapper USER_SERVICE_MAPPER = Mappers.getMapper(UserServiceMapper.class);
    AccountingOperationStatusServiceMapper ACCOUNTING_OPERATION_STATUS_SERVICE_MAPPER =
            Mappers.getMapper(AccountingOperationStatusServiceMapper.class);
    AccountingOperationTypeServiceMapper ACCOUNTING_OPERATION_TYPE_SERVICE_MAPPER =
            Mappers.getMapper(AccountingOperationTypeServiceMapper.class);

    @Override
    @Mapping(target = "accountingOperationType", source = "accountingOperationType", qualifiedByName = "accountingOperationEntityToModel")
    @Mapping(target = "client", source = "client", qualifiedByName = "clientEntityToClientModel")
    @Mapping(target = "assignedUser", source = "user", qualifiedByName = "userEntityToUserModel")
    @Mapping(target = "latestStatus", source = "latestStatus", qualifiedByName = "latestReportStatus")
    AccountingOperationModel toModel(AccountingOperationEntity entity);

    @Override
    @Mapping(target = "accountingOperationType", source = "accountingOperationType", qualifiedByName = "accountingOperationModelToEntity")
    @Mapping(target = "client", source = "client", qualifiedByName = "clientModelToClientEntity")
    @Mapping(target = "user", source = "assignedUser", qualifiedByName = "userModelToUserEntity")
    AccountingOperationEntity toEntity(AccountingOperationModel dto);

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

    @Named("latestReportStatus")
    default AccountingOperationStatusModel latestReportStatus(AccountingOperationStatusEntity entity) {
        return ACCOUNTING_OPERATION_STATUS_SERVICE_MAPPER.toModel(entity);
    }
}
