package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationStatusEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationTypeEntity;
import org.springframework.stereotype.Service;

@Service
public class ReportLatestStatusUtil {

    AccountingOperationStatusEntity fromReportType(AccountingOperationTypeEntity entity) {
        //todo implement logic to set the default status upon report type
        return new AccountingOperationStatusEntity(1L);
    }
}
