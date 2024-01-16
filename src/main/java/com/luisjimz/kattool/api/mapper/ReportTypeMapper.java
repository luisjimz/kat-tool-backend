package com.luisjimz.kattool.api.mapper;

import com.luisjimz.kattool.api.http.AccountingOperationCreateHttpRequest;
import com.luisjimz.kattool.model.AccountingOperationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportTypeMapper {
    AccountingOperationModel toModel(AccountingOperationCreateHttpRequest httpRequest);
}

