package com.luisjimz.kattool.service.mapper;


import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.persistence.entity.ReportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportServiceMapper extends ServiceMapper<ReportEntity, ReportModel>{

}
