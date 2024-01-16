package com.luisjimz.kattool.infrastructure.mapper;

import com.luisjimz.kattool.domain.model.ClientModel;
import com.luisjimz.kattool.infrastructure.persistence.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientServiceMapper extends ServiceMapper<ClientEntity, ClientModel> {
}
