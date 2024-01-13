package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import com.luisjimz.kattool.model.UserModel;
import org.mapstruct.Mapper;

@Mapper
public interface UserServiceMapper extends ServiceMapper<UserEntity, UserModel> {

}
