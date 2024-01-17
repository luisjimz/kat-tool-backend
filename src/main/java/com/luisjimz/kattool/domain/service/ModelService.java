package com.luisjimz.kattool.domain.service;

import java.util.Collection;

public interface ModelService<T> {
    Collection<T> getAll();
    T getAll(Long id);
    void delete(Long id);
    T create(T model);
//    Iterable<T> create(Iterable<T> models);
}
