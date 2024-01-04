package com.luisjimz.kattool.persistence.repository;

import com.luisjimz.kattool.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
