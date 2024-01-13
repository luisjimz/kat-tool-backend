package com.luisjimz.kattool;

import com.luisjimz.kattool.infrastructure.persistence.entity.ClientEntity;
import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import com.luisjimz.kattool.infrastructure.persistence.repository.ClientRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class Data {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        getClients().forEach(clientRepository::save);
        getUsers().forEach(userRepository::save);

    }

    private Collection<UserEntity> getUsers() {
        List<UserEntity> userEntities = new LinkedList<>();
        userEntities.add(
                new UserEntity(null, "Kathian", "Hernandez", "khernandez@mmasesoria.com")
        );
        userEntities.add(
                new UserEntity(null, "Victor", "Hernandez", "vhernandez@mmasesoria.com")
        );
        userEntities.add(
                new UserEntity(null, "Eduardo", "Martinez", "emartinez@mmasesoria.com")
        );
        return userEntities;
    }

    private Collection<ClientEntity> getClients() {
        List<ClientEntity> entities = new LinkedList<ClientEntity>();
        entities.add(
                new ClientEntity(
                        null,
                        "Atletico de Reynosa",
                        "Distibuidora laga",
                        "Juan Perez",
                        "8331002030",
                        "juan.perez@atletico.com",
                        "Tamaulipas"
                )
        );

        entities.add(
                new ClientEntity(
                        null,
                        "Distibuidora Alaga",
                        "contacto@distibuidoralaga.com",
                        "Juan Perez",
                        "8331492030",
                        "juan.perez@atletico.com",
                        "Tamaulipas"
                )
        );

        entities.add(
                new ClientEntity(
                        null,
                        "Industrial Basanlo",
                        "contacto@basanlo.com",
                        "Juan Perez",
                        "8334202030",
                        "juan.perez@atletico.com",
                        "Tamaulipas"
                )
        );
        return entities;
    }
}
