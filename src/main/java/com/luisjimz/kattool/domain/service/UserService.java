package com.luisjimz.kattool.domain.service;

import com.luisjimz.kattool.domain.model.UserModel;

import java.util.Collection;

public interface UserService {
    Collection<UserModel> get();
    UserModel get(Long id);
    void delete(Long id);
    UserModel save (UserModel userModel);
}
