package com.luisjimz.kattool.infrastructure.service;

import com.luisjimz.kattool.domain.model.UserModel;
import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import com.luisjimz.kattool.infrastructure.persistence.repository.UserRepository;
import com.luisjimz.kattool.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;
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
    public UserModel get(Long id) {
        return userRepository.findById(id).map(this::toModel).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserModel save(UserModel userModel) {
        var user = userRepository.save(this.toEntity(userModel));
        return this.toModel(user);
    }

    private UserModel toModel(UserEntity entity) {
        return new UserModel(
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail()
        );
    }

    private UserEntity toEntity(UserModel model) {
        var entity = new UserEntity();
        if(model.getId() != null) entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setLastName(model.getLastName());
        entity.setEmail(model.getEmail());
        return entity;
    }
}
