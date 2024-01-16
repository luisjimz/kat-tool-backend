package com.luisjimz.kattool.api.mapper;

import com.luisjimz.kattool.api.http.AccountingOperationCreateHttpRequest;
import com.luisjimz.kattool.model.AccountingOperationModel;
import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.model.AccountingOperationTypeModel;
import com.luisjimz.kattool.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AccountingOperationMapper {

    @Mapping(target = "accountingOperationType", source = "accountingOperationTypeId", qualifiedByName = "reportTypeToModel")
    AccountingOperationModel toModel(AccountingOperationCreateHttpRequest httpRequest);

    @Named("reportTypeToModel")
    default AccountingOperationTypeModel reportType(Long accountingOperationTypeId) {
        return AccountingOperationTypeModel.builder().id(accountingOperationTypeId).build();
    }
}
