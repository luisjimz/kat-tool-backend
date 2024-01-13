package com.luisjimz.kattool.controller.mapper;

import com.luisjimz.kattool.controller.http.ReportCreateHttpRequest;
import com.luisjimz.kattool.model.ReportModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportModel toModel(ReportCreateHttpRequest httpRequest);
}
