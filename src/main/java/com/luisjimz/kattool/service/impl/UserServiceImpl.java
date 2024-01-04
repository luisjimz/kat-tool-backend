package com.luisjimz.kattool.service.impl;

import com.luisjimz.kattool.model.UserModel;
import com.luisjimz.kattool.persistence.entity.UserEntity;
import com.luisjimz.kattool.persistence.repository.UserRepository;
import com.luisjimz.kattool.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public Collection<UserModel> get() {
        return userRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());

    }

    @Override
    public UserModel get(String id) {
        return userRepository.findById(id).map(this::toModel).orElse(null);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserModel save(UserModel userModel) {
        var user = userRepository.save(this.toEntity(userModel));
        return this.toModel(user);
    }

    private UserModel toModel(UserEntity entity) {
        return new UserModel(
                entity.getId().toString(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail()
        );
    }

    private UserEntity toEntity(UserModel model) {
        var entity = new UserEntity();
        if(model.getId() != null) entity.setId(UUID.fromString(model.getId()));
        entity.setName(model.getName());
        entity.setLastName(model.getLastName());
        entity.setEmail(model.getEmail());
        return entity;
    }
}
