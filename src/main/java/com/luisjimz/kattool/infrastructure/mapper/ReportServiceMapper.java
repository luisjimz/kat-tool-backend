package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.*;
import com.luisjimz.kattool.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportServiceMapper extends ServiceMapper<ReportEntity, ReportModel> {
    ReportTypeServiceMapper REPORT_TYPE_SERVICE_MAPPER = Mappers.getMapper(ReportTypeServiceMapper.class);
    ClientServiceMapper CLIENT_SERVICE_MAPPER = Mappers.getMapper(ClientServiceMapper.class);
    UserServiceMapper USER_SERVICE_MAPPER = Mappers.getMapper(UserServiceMapper.class);
    ReportStatusServiceMapper REPORT_STATUS_SERVICE_MAPPER = Mappers.getMapper(ReportStatusServiceMapper.class);

    @Override
    @Mapping(target = "reportType", source = "reportType", qualifiedByName = "reportTypeEntityToReportTypeModel")
    @Mapping(target = "client", source = "client", qualifiedByName = "clientEntityToClientModel")
    @Mapping(target = "assignedUser", source = "user", qualifiedByName = "userEntityToUserModel")
    @Mapping(target = "latestReportStatus", source = "latestReportStatus", qualifiedByName = "latestReportStatus")
    ReportModel toModel(ReportEntity entity);

    @Override
    @Mapping(target = "reportType", source = "reportType", qualifiedByName = "reportTypeModelToReportTypeEntity")
    @Mapping(target = "client", source = "client", qualifiedByName = "clientModelToClientEntity")
    @Mapping(target = "user", source = "assignedUser", qualifiedByName = "userModelToUserEntity")
    ReportEntity toEntity(ReportModel dto);

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

    @Named("reportTypeModelToReportTypeEntity")
    default ReportTypeEntity reportTypeModelToReportTypeEntity(ReportTypeModel model) {
        ReportTypeEntity reportTypeEntity = new ReportTypeEntity();
        reportTypeEntity.setId(model.getId());
        return reportTypeEntity;
    }

    @Named("reportTypeEntityToReportTypeModel")
    default ReportTypeModel reportType(ReportTypeEntity entity) {
        return REPORT_TYPE_SERVICE_MAPPER.toModel(entity);
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
    default ReportStatusModel latestReportStatus(ReportStatusEntity entity) {
        return REPORT_STATUS_SERVICE_MAPPER.toModel(entity);
    }
}
