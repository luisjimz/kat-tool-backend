package com.luisjimz.kattool.api.http.mapper;

import com.luisjimz.kattool.api.http.ReportCreateHttpRequest;
import com.luisjimz.kattool.model.ReportModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportTypeMapper {
    ReportModel toModel(ReportCreateHttpRequest httpRequest);
}

