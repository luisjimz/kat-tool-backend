package com.luisjimz.kattool.api.mapper;

import com.luisjimz.kattool.api.http.ReportCreateHttpRequest;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportTypeEntity;
import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.model.ReportTypeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    @Mapping(target = "reportType", source = "reportTypeId", qualifiedByName = "reportTypeToModel")
    ReportModel toModel(ReportCreateHttpRequest httpRequest);

    @Named("reportTypeToModel")
    default ReportTypeModel reportType(Long reportTypeId) {
        return ReportTypeModel.builder().id(reportTypeId).build();
    }

}
