package com.luisjimz.kattool.infrastructure.mapper;

public interface ServiceMapper<E, DTO> {
    DTO toModel(E e);
    E toEntity(DTO dto);
}
