package com.luisjimz.kattool.api.mapper;

import com.luisjimz.kattool.api.http.AccountingOperationCreateHttpRequest;
import com.luisjimz.kattool.domain.model.AccountingOperationModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountingOperationTypeMapper {
    AccountingOperationModel toModel(AccountingOperationCreateHttpRequest httpRequest);
}

