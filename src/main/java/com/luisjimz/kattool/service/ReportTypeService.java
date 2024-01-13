package com.luisjimz.kattool.service;

import com.luisjimz.kattool.model.ReportTypeModel;

import java.util.List;
import java.util.Optional;

public interface ReportTypeService {
    List<ReportTypeModel> getAll();
    Optional<ReportTypeModel> get(Long id);
}
