package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.domain.model.AccountingOperationModel;
import com.luisjimz.kattool.domain.model.AccountingReportModel;
import com.luisjimz.kattool.domain.service.AccountingOperationService;
import com.luisjimz.kattool.domain.service.AccountingReportService;
import com.luisjimz.kattool.infrastructure.mapper.AccountingOperationServiceMapper;
import com.luisjimz.kattool.infrastructure.mapper.AccountingOperationTypeServiceMapper;
import com.luisjimz.kattool.infrastructure.mapper.AccountingReportServiceMapper;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationTypeEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingReportEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.ClientEntity;
import com.luisjimz.kattool.infrastructure.persistence.repository.AccountingOperationRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.AccountingReportRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountingReportServiceImpl implements AccountingReportService {

    private final AccountingReportRepository repository;
    private final AccountingReportServiceMapper mapper;
    private final ClientRepository clientRepository;
    private final AccountingOperationServiceMapper accountingOperationServiceMapper;
    private final AccountingOperationTypeServiceMapper accountingOperationTypeServiceMapper;
    private final AccountingOperationServiceImpl accountingOperationService;

    @Override
    public AccountingReportModel save(AccountingReportModel reportModel) {
        throw new RuntimeException("method not implemented");
//        return null;
    }

    @Override
    public Collection<AccountingReportModel> getAll() {
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public AccountingReportModel getAll(Long id) {
        return mapper.toModel(repository.findById(id).get());
    }

    @Override
    public AccountingReportModel create(AccountingReportModel model) {
        ClientEntity clientEntity = clientRepository.findById(model.getClient().getId()).get();
        AccountingReportEntity targetEntity = mapper.toEntity(model);
        targetEntity = repository.save(targetEntity);

        List<AccountingOperationModel> accountingOperationModels = new LinkedList<>();
        for (AccountingOperationTypeEntity accountingOperationTypeEntity : clientEntity.getOperationTypes()) {
            accountingOperationModels.add(new AccountingOperationModel(
                    null,
                    mapper.toModel(targetEntity),
                    accountingOperationTypeServiceMapper.toModel(accountingOperationTypeEntity),
                    null,
                    null
            ));
        }

        accountingOperationService.create(accountingOperationModels);
        return mapper.toModel(targetEntity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AccountingReportModel> findByDateSlug(String dateSlug) {

        return null;
    }

    @Override
    public Collection<AccountingReportModel> get(String dateSlug) {
        if (dateSlug == null)
            return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
        int[] yearAndMonth = DateUtil.getYearAndMonth(dateSlug);
        return repository.findByYearAndMonth(yearAndMonth[0], yearAndMonth[1])
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }
}
