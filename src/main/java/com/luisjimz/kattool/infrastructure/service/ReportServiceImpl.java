package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.api.service.ReportService;
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
    @Override
    public Collection<ReportModel> get() {
        Object a = repository.findAll();
        return repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public ReportModel get(String id) {
        Optional<ReportModel> o = repository.findById(UUID.fromString(id)).map(mapper::toModel);
        return o.get();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public ReportModel save(ReportModel model) {
        ReportEntity entity = mapper.toEntity(model);
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
}
