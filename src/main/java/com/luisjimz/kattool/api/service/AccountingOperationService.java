package com.luisjimz.kattool.api.service;

import com.luisjimz.kattool.model.AccountingOperationModel;

import java.util.Collection;

public interface AccountingOperationService extends ModelService<AccountingOperationModel> {
    Collection<AccountingOperationModel> findByUser(Long userId);
    Collection<AccountingOperationModel> findByClient(Long clientId);
    Collection<AccountingOperationModel> findByUserAndDateSlug(Long userId, String dateSlug);
    Collection<AccountingOperationModel> findByDateSlug(String dateSlug);

}
