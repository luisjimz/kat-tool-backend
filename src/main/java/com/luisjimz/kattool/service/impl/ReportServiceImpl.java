package com.luisjimz.kattool.service.impl;

import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.persistence.repository.ReportRepository;
import com.luisjimz.kattool.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private ReportRepository repository;
    @Override
    public Collection<ReportModel> get() {
        return null;
    }

    @Override
    public ReportModel get(String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ReportModel save(ReportModel model) {
        return null;
    }
}
