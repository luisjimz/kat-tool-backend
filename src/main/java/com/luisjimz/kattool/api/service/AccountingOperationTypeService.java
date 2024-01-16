package com.luisjimz.kattool.api.service;

import com.luisjimz.kattool.model.AccountingOperationTypeModel;

import java.util.List;
import java.util.Optional;

public interface AccountingOperationTypeService {
    List<AccountingOperationTypeModel> getAll();
    Optional<AccountingOperationTypeModel> get(Long id);
}
