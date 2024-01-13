package com.luisjimz.kattool.api.mapper;

import com.luisjimz.kattool.api.http.ClientCreateHttpRequest;
import com.luisjimz.kattool.model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ClientMapper {

//    @Mapping(source = "id", target = "id", qualifiedByName = "stringToUUID")
    @Mapping(target = "id", ignore = true) // If 'id' should not be mapped
    @Mapping(target = "reports", ignore = true) // If 'reports' should not be mapped
    ClientModel toModel(ClientCreateHttpRequest httpRequest);

    @Named("stringToUUID")
    default UUID stringToUUID(String id) {
        return id == null ? null : UUID.fromString(id);
    }
}
