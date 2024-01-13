package com.luisjimz.kattool.infrastructure.service.mapper;

public interface ServiceMapper<E, DTO> {
    DTO toModel(E e);
    E toEntity(DTO dto);
}
