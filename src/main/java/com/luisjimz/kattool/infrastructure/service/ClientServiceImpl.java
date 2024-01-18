package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.domain.model.ClientModel;
import com.luisjimz.kattool.domain.service.ClientService;
import com.luisjimz.kattool.infrastructure.mapper.ClientServiceMapper;
import com.luisjimz.kattool.infrastructure.persistence.entity.ClientEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import com.luisjimz.kattool.infrastructure.persistence.repository.AccountingOperationTypeRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.ClientRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;
    private UserRepository userRepository;
    private ClientServiceMapper mapper;
    private AccountingOperationTypeRepository accountingOperationTypeRepository;

    @Override
    public ClientModel save(ClientModel model) {
        userRepository.findById(model.getAssignedAccountant().getId());
        return mapper.toModel(this.repository.save(mapper.toEntity(model)));
    }

    @Override
    public Collection<ClientModel> getAll() {
        return this.repository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public ClientModel getAll(Long id) {
        return repository.findById(id).map(mapper::toModel).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public ClientModel create(ClientModel model) {
        UserEntity userEntity = userRepository.findById(model.getAssignedAccountant().getId()).get();
        ClientEntity newEntity = mapper.toEntity(model);
        newEntity.setAssignedAccountant(userEntity);
        return mapper.toModel(this.repository.save(newEntity));    }
}
