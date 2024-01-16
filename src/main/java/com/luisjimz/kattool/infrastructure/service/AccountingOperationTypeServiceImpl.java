package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.model.AccountingOperationTypeModel;
import com.luisjimz.kattool.infrastructure.persistence.repository.AccountingOperationTypeRepository;
import com.luisjimz.kattool.api.service.AccountingOperationTypeService;
import com.luisjimz.kattool.infrastructure.mapper.AccountingOperationTypeServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountingOperationTypeServiceImpl implements AccountingOperationTypeService {

    private AccountingOperationTypeRepository repository;
    private AccountingOperationTypeServiceMapper mapper;
    @Override
    public List<AccountingOperationTypeModel> getAll() {
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Optional<AccountingOperationTypeModel> get(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }
}
