package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.api.service.ReportService;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportStatusEntity;
import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.infrastructure.persistence.entity.ReportEntity;
import com.luisjimz.kattool.infrastructure.persistence.repository.ReportRepository;
import com.luisjimz.kattool.infrastructure.mapper.ReportServiceMapper;
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
    private ReportLatestStatusUtil reportLatestStatusUtil;

    @Override
    public Collection<ReportModel> get() {
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public ReportModel get(Long id) {
        Optional<ReportModel> o = repository.findById(id).map(mapper::toModel);
        return o.get();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ReportModel save(ReportModel model) {
        ReportEntity entity = mapper.toEntity(model);
        entity.setLatestReportStatus(reportLatestStatusUtil.fromReportType(entity.getReportType()));
        entity = repository.save(entity);
        return mapper.toModel(entity);
    }

    @Override
    public Collection<ReportModel> findByUser(Long userId) {
        return this.repository.findByUserId(userId)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }


    @Override
    public Collection<ReportModel> findByClient(Long clientId) {
        return this.repository.findByClientId(clientId)
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<ReportModel> findByUserAndDateSlug(Long userId, String dateSlug) {
        int[] date = DateUtil.getYearAndMonth(dateSlug);
        return repository.findByYearAndMonth(date[0], date[1])
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<ReportModel> findByDateSlug(String dateSlug) {
        int[] date = DateUtil.getYearAndMonth(dateSlug);
        return repository.findByYearAndMonth(date[0], date[1])
                .stream()
                .map(mapper::toModel)
                .collect(Collectors.toList());
    }
}
