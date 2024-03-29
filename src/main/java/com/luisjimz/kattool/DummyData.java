package com.luisjimz.kattool;

import com.luisjimz.kattool.infrastructure.persistence.entity.*;
import com.luisjimz.kattool.infrastructure.persistence.repository.ClientRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.AccountingOperationStatusRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.AccountingOperationTypeRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class DummyData {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final AccountingOperationStatusRepository accountingOperationStatusRepository;
    private final AccountingOperationTypeRepository accountingOperationTypeRepository;
    private final Environment environment;
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        if ("create".equals(environment.getProperty("spring.jpa.hibernate.ddl-auto"))) {
            getUsers().forEach(userRepository::save);
            getClients().forEach(clientRepository::save);
            getReportStatuses().forEach(accountingOperationStatusRepository::save);
            getReportTypes().forEach(accountingOperationTypeRepository::save);
            setOperationStatus();
        }
    }

    public void setOperationStatus() {
        List<AccountingOperationTypeEntity> entities = accountingOperationTypeRepository.findAll();
        entities.forEach(entity -> {
            entity.setStatuses(
                    List.of(
                            new AccountingOperationStatusEntity(1L),
                            new AccountingOperationStatusEntity(2L),
                            new AccountingOperationStatusEntity(3L),
                            new AccountingOperationStatusEntity(4L),
                            new AccountingOperationStatusEntity(5L),
                            new AccountingOperationStatusEntity(6L),
                            new AccountingOperationStatusEntity(7L),
                            new AccountingOperationStatusEntity(8L)

                    )
            );
            accountingOperationTypeRepository.save(entity);
        });
    }
    public List<AccountingOperationTypeEntity> getReportTypes() {
        List<AccountingOperationTypeEntity> entities = new LinkedList<>();
        entities.add(
                new AccountingOperationTypeEntity(
                      1L,
                      "Impuestos federales",
                      "Descripción de Contabilidad de impuestos federales",
                        null
                )
        );
        entities.add(
                new AccountingOperationTypeEntity(
                        2L,
                        "Impuestos estatales",
                        "Descripción de Presentacion de impuestos estatales",
                        null
                )
        );
        entities.add(
                new AccountingOperationTypeEntity(3L,
                        "Nominas",
                        "Descripción de Proceso de nomina",
                        null
                )
        );
        entities.add(
                new AccountingOperationTypeEntity(
                        4L,
                        "Actualizaciones del IMSS",
                        "Descripción de Actualizaciones del IMSS",
                        null
                )
        );
        entities.add(
                new AccountingOperationTypeEntity(
                        5L,
                        "Actos administrativos SAT",
                        "Descripción de Actos administrativos SAT",
                        null
                )
        );
        return entities;
    }
    /*
       WAITING_DOCUMENTS = 'En espera de documentacion',
        UNDER_ACCOUNTING = 'En contabilizacion',
        UNDER_REVIEW = 'En revision',
        PENDING_SEND_TAX_LETTER = 'En espera de enviar carta de impuestos',
        PENDING_APPROVAL = 'En aprobacion',
        PENDING_SEND_STATEMENT = 'Pendiente declaración',
        STATEMENT_SENT = 'Declaracion enviada',
        DONE = 'Cuenta cerrada',
        UNKNOWN_STATUS = 'Contact support'
     */

    private Collection <AccountingOperationStatusEntity> getReportStatuses() {
        List<AccountingOperationStatusEntity> reportStatusEntities = new LinkedList<>();
        reportStatusEntities.add(
                new AccountingOperationStatusEntity(null,
                        0,
                        "WAITING_DOCUMENTS",
                        "En espera de documentos por parte del cliente",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new AccountingOperationStatusEntity(null,
                        1,
                        "UNDER_ACCOUNTING",
                        "En contabilizacion",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new AccountingOperationStatusEntity(null,
                        2,
                        "UNDER_REVIEW",
                        "Bajo revision de supervisor",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new AccountingOperationStatusEntity(null,
                        3,
                        "PENDING_SEND_TAX_LETTER",
                        "Pendiente de enviar carta de impuestos",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new AccountingOperationStatusEntity(null,
                        4,
                        "PENDING_APPROVAL",
                        "Pendiente de enviar carta de impuestos",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new AccountingOperationStatusEntity(null,
                        5,
                        "PENDING_SEND_STATEMENT",
                        "Carta de impuestos enviada",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new AccountingOperationStatusEntity(null,
                        6,
                        "STATEMENT_SENT",
                        "Carta de impuestos enviada",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new AccountingOperationStatusEntity(null,
                        100,
                        "DONE",
                        "Servicio terminado",
                        "#84cc16")
        );
        return reportStatusEntities;
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
        Set<AccountingOperationTypeEntity> operations = Set.of(
                new AccountingOperationTypeEntity(1L),
                new AccountingOperationTypeEntity(2L),
                new AccountingOperationTypeEntity(3L),
                new AccountingOperationTypeEntity(4L),
                new AccountingOperationTypeEntity(5L)
        );
        entities.add(
                new ClientEntity(
                        null,
                        "Agape Muebleria",
                        "JIAL940215487",
                        "luisjimz94@gmail.com",
                        "Luis Jimenez",
                        "8333248978",
                        "Doña Cecilia #907, Colonia Lazaro Cardenas",
                        "Tamaulipas",
                        null,
                        UserEntity.builder().id(1L).build()
                )
        );

        entities.add(
                new ClientEntity(
                        null,
                        "Distibuidora Alaga",
                        "XEXX010101000",
                        "contacto@distibuidoralaga.com",
                        "Juan Perez",
                        "8331492030",
                        "Greene Avenue #1131, Bushwick",
                        "Tamaulipas",
                        null,
                        UserEntity.builder().id(1L).build()
                )
        );

        entities.add(
                new ClientEntity(
                        null,
                        "Industrial Basanlo",
                        "XEXX010101000",
                        "contacto@basanlo.com",
                        "Juan Perez",
                        "8334202030",
                        "Greene Avenue #1131, Bushwick",
                        "Tamaulipas",
                        null,
                        UserEntity.builder().id(1L).build()
                )
        );
        return entities;
    }
}
