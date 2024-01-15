package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.ReportStatusEntity;
import com.luisjimz.kattool.model.ReportStatusModel;
import com.luisjimz.kattool.model.ReportTypeModel;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ReportTypeServiceMapper extends ServiceMapper<ReportTypeEntity, ReportTypeModel> {

    @Override
    @Mapping(target = "statuses", source = "statuses", qualifiedByName = "reportStatuses")
    ReportTypeModel toModel(ReportTypeEntity entity);

    ReportStatusServiceMapper REPORT_STATUS_SERVICE_MAPPER = Mappers.getMapper(ReportStatusServiceMapper.class);

    @Named("reportStatuses")
    default Set<ReportStatusModel> reportsStatuses(Set<ReportStatusEntity> entities) {
        if(entities == null || entities.isEmpty()) return Set.of();
        return entities.stream().map(REPORT_STATUS_SERVICE_MAPPER::toModel).collect(Collectors.toSet());
    }
}
