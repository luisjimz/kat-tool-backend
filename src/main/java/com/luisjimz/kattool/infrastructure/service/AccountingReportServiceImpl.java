package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.domain.model.AccountingReportModel;
import com.luisjimz.kattool.domain.service.AccountingOperationService;
import com.luisjimz.kattool.domain.service.AccountingReportService;
import com.luisjimz.kattool.infrastructure.mapper.AccountingReportServiceMapper;
import com.luisjimz.kattool.infrastructure.persistence.repository.AccountingReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountingReportServiceImpl implements AccountingReportService {

    private final AccountingReportRepository repository;
    private final AccountingReportServiceMapper mapper;
    private final AccountingOperationService accountingOperationService;
    @Override
    public Collection<AccountingReportModel> getAll() {
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public AccountingReportModel getAll(Long id) {
        return mapper.toModel(repository.findById(id).get());
    }

    @Override
    public AccountingReportModel save(AccountingReportModel model) {
        return mapper.toModel(repository.save(mapper.toEntity(model)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
