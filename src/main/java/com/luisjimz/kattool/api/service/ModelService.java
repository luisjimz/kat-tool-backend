package com.luisjimz.kattool.api.service;

import java.util.Collection;

public interface ModelService<T> {
    Collection<T> get();
    T get(Long id);
    void delete(Long id);
    T save (T model);
}
