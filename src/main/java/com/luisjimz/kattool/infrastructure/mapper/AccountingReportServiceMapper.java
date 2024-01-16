package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingReportEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.ClientEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import com.luisjimz.kattool.model.AccountingReportModel;
import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountingReportServiceMapper extends ServiceMapper<AccountingReportEntity, AccountingReportModel> {

    ClientServiceMapper CLIENT_SERVICE_MAPPER = Mappers.getMapper(ClientServiceMapper.class);
    UserServiceMapper USER_SERVICE_MAPPER = Mappers.getMapper(UserServiceMapper.class);

    @Override
    @Mapping(target = "client", source = "client", qualifiedByName = "clientModelToClientEntity")
    @Mapping(target = "assignedUser", source = "assignedUser", qualifiedByName = "userModelToUserEntity")
    AccountingReportEntity toEntity(AccountingReportModel model);

    @Override
    @Mapping(target = "client", source = "client", qualifiedByName = "clientEntityToClientModel")
    @Mapping(target = "assignedUser", source = "assignedUser", qualifiedByName = "userEntityToUserModel")
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
}
