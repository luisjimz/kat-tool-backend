package com.luisjimz.kattool.controller.mapper;

import com.luisjimz.kattool.controller.http.ClientCreateHttpRequest;
import com.luisjimz.kattool.model.ClientModel;
import org.mapstruct.Mapper;


@Mapper
public interface ClientMapper {
    ClientModel toModel(ClientCreateHttpRequest httpRequest);
}
