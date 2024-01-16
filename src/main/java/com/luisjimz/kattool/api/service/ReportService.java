package com.luisjimz.kattool.api.service;

import com.luisjimz.kattool.model.ReportModel;

import java.util.Collection;

public interface ReportService extends ModelService<ReportModel> {
    Collection<ReportModel> findByUser(Long userId);
    Collection<ReportModel> findByClient(Long clientId);
    Collection<ReportModel> findByUserAndDateSlug(Long userId, String dateSlug);
    Collection<ReportModel> findByDateSlug(String dateSlug);

}
