package com.luisjimz.kattool.service.mapper;

import com.luisjimz.kattool.model.ReportTypeModel;
import com.luisjimz.kattool.persistence.entity.ReportTypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportTypeServiceMapper extends ServiceMapper<ReportTypeEntity, ReportTypeModel> {
}
