package com.luisjimz.kattool.service.mapper;

import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.persistence.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientServiceMapper extends ServiceMapper<ClientEntity, ClientModel> {
}
