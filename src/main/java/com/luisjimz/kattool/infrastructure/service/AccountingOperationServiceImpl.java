package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.api.service.AccountingOperationService;
import com.luisjimz.kattool.infrastructure.mapper.AccountingOperationServiceMapper;
import com.luisjimz.kattool.infrastructure.persistence.entity.AccountingOperationEntity;
import com.luisjimz.kattool.model.AccountingOperationModel;
import com.luisjimz.kattool.infrastructure.persistence.repository.AccountingOperationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountingOperationServiceImpl implements AccountingOperationService {

    private AccountingOperationRepository repository;
    private AccountingOperationServiceMapper mapper;
    private ReportLatestStatusUtil reportLatestStatusUtil;

    @Override
    public Collection<AccountingOperationModel> get() {
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public AccountingOperationModel get(Long id) {
        Optional<AccountingOperationModel> o = repository.findById(id).map(mapper::toModel);
        return o.get();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public AccountingOperationModel save(AccountingOperationModel model) {
        AccountingOperationEntity entity = mapper.toEntity(model);
        entity.setLatestReportStatus(reportLatestStatusUtil.fromReportType(entity.getReportType()));
        entity = repository.save(entity);
        return mapper.toModel(entity);
    }

    @Override
    public Collection<AccountingOperationModel> findByUser(Long userId) {
        return this.repository.findByUserId(userId)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }


    @Override
    public Collection<AccountingOperationModel> findByClient(Long clientId) {
        return this.repository.findByClientId(clientId)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<AccountingOperationModel> findByUserAndDateSlug(Long userId, String dateSlug) {
        int[] date = DateUtil.getYearAndMonth(dateSlug);
        return repository.findByYearAndMonth(date[0], date[1])
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<AccountingOperationModel> findByDateSlug(String dateSlug) {
        int[] date = DateUtil.getYearAndMonth(dateSlug);
        return repository.findByYearAndMonth(date[0], date[1])
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }
}
