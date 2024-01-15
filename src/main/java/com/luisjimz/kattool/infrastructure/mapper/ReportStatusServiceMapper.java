package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.ReportStatusEntity;
import com.luisjimz.kattool.model.ReportStatusModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportStatusServiceMapper extends ServiceMapper <ReportStatusEntity, ReportStatusModel> {
}
