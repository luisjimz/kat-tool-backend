package com.luisjimz.kattool.api.service;

import java.util.Collection;

public interface ModelService<T> {
    Collection<T> get();
    T get(String id);
    void delete(String id);
    T save (T model);
}
