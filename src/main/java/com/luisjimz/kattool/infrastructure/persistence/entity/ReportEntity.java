package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="report_type_id", nullable=false)
    private ReportTypeEntity reportType;

    private String clientId;

    private String assignedAccountant;
    //todo hacer una tabla con llave compuesta para guardar Status de Reporte por tipo de reporte
    private String reportStatus; //default =>
}
