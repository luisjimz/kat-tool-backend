package com.luisjimz.kattool;

import com.luisjimz.kattool.infrastructure.persistence.entity.*;
import com.luisjimz.kattool.infrastructure.persistence.repository.ClientRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.ReportStatusRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.ReportTypeRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class Data {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final ReportStatusRepository reportStatusRepository;
    private final ReportTypeRepository reportTypeRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        getClients().forEach(clientRepository::save);
        getUsers().forEach(userRepository::save);
        getReportStatuses().forEach(reportStatusRepository::save);
        ReportTypeEntity entity = reportTypeRepository.findById(1L).get();
        entity.setStatuses(
                Set.of(
                        new ReportStatusEntity(1L),
                        new ReportStatusEntity(2L),
                        new ReportStatusEntity(3L),
                        new ReportStatusEntity(4L),
                        new ReportStatusEntity(5L),
                        new ReportStatusEntity(6L),
                        new ReportStatusEntity(7L),
                        new ReportStatusEntity(8L)

                )
        );
        reportTypeRepository.save(entity);
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

    private Collection <ReportStatusEntity> getReportStatuses() {
        List<ReportStatusEntity> reportStatusEntities = new LinkedList<>();
        reportStatusEntities.add(
                new ReportStatusEntity(null,
                        0,
                        "WAITING_DOCUMENTS",
                        "En espera de documentos por parte del cliente",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null,
                        0,
                        "UNDER_ACCOUNTING",
                        "En contabilizacion",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null,
                        0,
                        "UNDER_REVIEW",
                        "Bajo revision de supervisor",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null,
                        0,
                        "PENDING_SEND_TAX_LETTER",
                        "Pendiente de enviar carta de impuestos",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null,
                        0,
                        "PENDING_APPROVAL",
                        "Pendiente de enviar carta de impuestos",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null,
                        0,
                        "PENDING_SEND_STATEMENT",
                        "Carta de impuestos enviada",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null,
                        0,
                        "STATEMENT_SENT",
                        "Carta de impuestos enviada",
                        "#84cc16")
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null,
                        1,
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
