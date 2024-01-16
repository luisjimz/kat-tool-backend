package com.luisjimz.kattool.domain.service;

import com.luisjimz.kattool.domain.model.AccountingOperationTypeModel;

import java.util.List;
import java.util.Optional;

public interface AccountingOperationTypeService {
    List<AccountingOperationTypeModel> getAll();
    Optional<AccountingOperationTypeModel> get(Long id);
}
