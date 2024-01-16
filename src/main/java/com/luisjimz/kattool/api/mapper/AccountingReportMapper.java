package com.luisjimz.kattool.api.mapper;

import com.luisjimz.kattool.api.http.AccountingReportCreateHttpRequest;
import com.luisjimz.kattool.domain.model.AccountingReportModel;
import com.luisjimz.kattool.domain.model.ClientModel;
import com.luisjimz.kattool.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AccountingReportMapper  {

    @Mapping(target = "client", source = "clientId", qualifiedByName = "clientIdToClientModel")
    @Mapping(target = "assignedUser", source = "userId", qualifiedByName = "userIdToUserModel")
    AccountingReportModel toModel(AccountingReportCreateHttpRequest httpRequest);

    @Named("clientIdToClientModel")
    default ClientModel clientIdToClientModel(Long clientId) {
        return ClientModel.builder().id(clientId).build();
    }

    @Named("userIdToUserModel")
    default UserModel userIdToUserModel(Long userId) {
        return UserModel.builder().id(userId).build();
    }
}
