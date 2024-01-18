package com.luisjimz.kattool.domain.service;

import com.luisjimz.kattool.domain.model.AccountingReportModel;

import java.util.Collection;
import java.util.List;

public interface AccountingReportService extends ModelService<AccountingReportModel>{
    List<AccountingReportModel> findByDateSlug(String dateSlug);

    Collection<AccountingReportModel> get(String dateSlug);
}
