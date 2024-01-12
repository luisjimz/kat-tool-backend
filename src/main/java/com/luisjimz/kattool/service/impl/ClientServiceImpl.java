package com.luisjimz.kattool.service.impl;

import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.persistence.entity.ClientEntity;
import com.luisjimz.kattool.persistence.repository.ClientRepository;
import com.luisjimz.kattool.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;

    @Override
    public Collection<ClientModel> get() {
        return this.repository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public ClientModel get(String id) {
        return repository.findById(UUID.fromString(id)).map(this::toModel).orElse(null);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public ClientModel save(ClientModel userModel) {
        return this.toModel(repository.save(toEntity(userModel)));
    }

    private ClientModel toModel(ClientEntity entity) {
        return new ClientModel(
                entity.getId().toString(),
                entity.getName(),
                entity.getEmail()
        );
    }

    private ClientEntity toEntity(ClientModel model) {
        ClientEntity entity = new ClientEntity();
        if(model.getId() != null) entity.setId(UUID.fromString(model.getId()));
        entity.setName(model.getName());
        entity.setEmail(model.getEmail());
        return entity;
    }
}
