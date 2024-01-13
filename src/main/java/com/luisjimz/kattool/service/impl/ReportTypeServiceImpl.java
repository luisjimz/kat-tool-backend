package com.luisjimz.kattool.service.impl;

import com.luisjimz.kattool.model.ReportTypeModel;
import com.luisjimz.kattool.persistence.repository.ReportTypeRepository;
import com.luisjimz.kattool.service.ReportTypeService;
import com.luisjimz.kattool.service.mapper.ReportTypeServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportTypeServiceImpl implements ReportTypeService {

    private ReportTypeRepository repository;
    private ReportTypeServiceMapper mapper;
    @Override
    public List<ReportTypeModel> getAll() {
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<ReportTypeModel> get(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }
}
