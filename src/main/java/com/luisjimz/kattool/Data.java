package com.luisjimz.kattool;

import com.luisjimz.kattool.infrastructure.persistence.entity.*;
import com.luisjimz.kattool.infrastructure.persistence.repository.ClientRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.ReportStatusRepository;
import com.luisjimz.kattool.infrastructure.persistence.repository.ReportTypeReportStatusRepository;
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
    private final ReportStatusRepository reportStatusRepository;
    private final ReportTypeReportStatusRepository reportTypeReportStatusRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        getClients().forEach(clientRepository::save);
        getUsers().forEach(userRepository::save);
        getReportStatuses().forEach(reportStatusRepository::save);
        getStatusRelationship().forEach(reportTypeReportStatusRepository::save);
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
                        "waiting_documents",
                        "En espera de documentos por parte del cliente",
                        "#84cc16",
                        null)
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null, 1, "under_accounting", "","#84cc16", null)
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null, 1, "under_review", "","#84cc16", null)
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null, 1, "pending_send_tax_letter", "","#84cc16", null)
        );
        reportStatusEntities.add(
                new ReportStatusEntity(null, 100, "done", "Completado","#84cc16", null)
        );

        return reportStatusEntities;
    }

    private Collection<ReportTypeReportStatusEntity> getStatusRelationship() {
        List<ReportTypeReportStatusEntity> reportTypeReportStatusEntities = new LinkedList<>();
        reportTypeReportStatusEntities.add(
                new ReportTypeReportStatusEntity(
                        null,
                        new ReportTypeEntity(1L),
                        new ReportStatusEntity(1L)
                )
        );

        reportTypeReportStatusEntities.add(
                new ReportTypeReportStatusEntity(
                        null,
                        new ReportTypeEntity(1L),
                        new ReportStatusEntity(2L)
                )
        );

        reportTypeReportStatusEntities.add(
                new ReportTypeReportStatusEntity(
                        null,
                        new ReportTypeEntity(1L),
                        new ReportStatusEntity(3L)
                )
        );
        reportTypeReportStatusEntities.add(
                new ReportTypeReportStatusEntity(
                        null,
                        new ReportTypeEntity(1L),
                        new ReportStatusEntity(4L)
                )
        );
        return reportTypeReportStatusEntities;
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
