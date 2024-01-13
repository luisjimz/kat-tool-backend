package com.luisjimz.kattool.infrastructure.service.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.ReportEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportTypeEntity;
import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.model.ReportTypeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReportServiceMapper extends ServiceMapper<ReportEntity, ReportModel> {
    ReportTypeServiceMapper INSTANCE = Mappers.getMapper(ReportTypeServiceMapper.class);

    @Override
    @Mapping(target = "reportType", source = "reportType", qualifiedByName = "reportTypeToModel")
    ReportModel toModel(ReportEntity entity);

    @Override
    @Mapping(target = "reportType", source = "reportType", qualifiedByName = "reportTypeToEntity")
    ReportEntity toEntity(ReportModel dto);

    @Named("reportTypeToEntity")
    default ReportTypeEntity reportTypeToEntity(ReportTypeModel model) {
        ReportTypeEntity reportTypeEntity = new ReportTypeEntity();
        reportTypeEntity.setId(model.getId());
        return reportTypeEntity;
    }

    @Named("reportTypeToModel")
    default ReportTypeModel reportType(ReportTypeEntity entity) {
        return INSTANCE.toModel(entity);
    }
}
