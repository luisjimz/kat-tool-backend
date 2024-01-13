package com.luisjimz.kattool.service.impl;

import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.persistence.entity.ReportEntity;
import com.luisjimz.kattool.persistence.repository.ReportRepository;
import com.luisjimz.kattool.service.ReportService;
import com.luisjimz.kattool.service.mapper.ReportServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private ReportRepository repository;
    private ReportServiceMapper mapper;
    @Override
    public Collection<ReportModel> get() {
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public ReportModel get(String id) {
        Optional<ReportModel> o = repository.findById(UUID.fromString(id)).map(mapper::toModel);
        return o.get();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ReportModel save(ReportModel model) {
        return null;
    }
}
