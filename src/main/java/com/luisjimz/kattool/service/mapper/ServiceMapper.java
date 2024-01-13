package com.luisjimz.kattool.service.mapper;

public interface ServiceMapper<E, DTO> {
    DTO toModel(E e);
    E toEntity(DTO dto);
}
