package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.infrastructure.persistence.repository.ClientRepository;
import com.luisjimz.kattool.api.service.ClientService;
import com.luisjimz.kattool.infrastructure.mapper.ClientServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;
    private ClientServiceMapper mapper;


    @Override
    public Collection<ClientModel> get() {
        return this.repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public ClientModel get(Long id) {
        return repository.findById(id).map(mapper::toModel).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public ClientModel save(ClientModel userModel) {
        return mapper.toModel(repository.save(mapper.toEntity(userModel)));
    }
}
