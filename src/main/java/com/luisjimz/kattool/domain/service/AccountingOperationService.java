package com.luisjimz.kattool.domain.service;

import com.luisjimz.kattool.domain.model.AccountingOperationModel;

import java.util.Collection;

public interface AccountingOperationService extends ModelService<AccountingOperationModel> {
    Collection<AccountingOperationModel> findByDateSlug(String dateSlug);
    AccountingOperationModel updateLatestStatus(Long oprationId, Long statusId);

}
