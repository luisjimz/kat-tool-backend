package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.infrastructure.persistence.entity.ReportStatusEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportTypeEntity;
import org.springframework.stereotype.Service;

@Service
public class ReportLatestStatusUtil {

    ReportStatusEntity fromReportType(ReportTypeEntity entity) {

        return new ReportStatusEntity();
    }
}
