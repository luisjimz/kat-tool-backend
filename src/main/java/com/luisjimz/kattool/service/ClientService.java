package com.luisjimz.kattool.service;

import com.luisjimz.kattool.model.ClientModel;

import java.util.Collection;

public interface ClientService {
    Collection<ClientModel> get();
    ClientModel get(String id);
    void delete(String id);
    ClientModel save (ClientModel userModel);
}
