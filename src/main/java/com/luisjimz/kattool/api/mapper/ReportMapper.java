package com.luisjimz.kattool.api.mapper;

import com.luisjimz.kattool.api.http.ReportCreateHttpRequest;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportTypeEntity;
import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.model.ReportTypeModel;
import com.luisjimz.kattool.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    @Mapping(target = "reportType", source = "reportTypeId", qualifiedByName = "reportTypeToModel")
    @Mapping(target = "client", source = "clientId", qualifiedByName = "clientIdToClientModel")
    @Mapping(target = "assignedUser", source = "userId", qualifiedByName = "userIdToUserModel")
    ReportModel toModel(ReportCreateHttpRequest httpRequest);

    @Named("reportTypeToModel")
    default ReportTypeModel reportType(Long reportTypeId) {
        return ReportTypeModel.builder().id(reportTypeId).build();
    }

    @Named("clientIdToClientModel")
    default ClientModel clientIdToClientModel(Long clientId) {
        return ClientModel.builder().id(clientId).build();
    }

    @Named("userIdToUserModel")
    default UserModel userIdToUserModel(Long userId) {
        return UserModel.builder().id(userId).build();
    }
}
