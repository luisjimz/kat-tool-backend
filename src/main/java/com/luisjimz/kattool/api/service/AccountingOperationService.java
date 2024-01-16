package com.luisjimz.kattool.api.service;

import com.luisjimz.kattool.model.AccountingOperationModel;

import java.util.Collection;

public interface AccountingOperationService extends ModelService<AccountingOperationModel> {
    Collection<AccountingOperationModel> findByDateSlug(String dateSlug);

}
