package com.luisjimz.kattool.persistence.entity;

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
    private Long reportTypeId;
    private String clientId;
    private String assignedAccountant;
    //todo hacer una tabla con llave compuesta para guardar Status de Reporte por tipo de reporte
    private String reportStatus; //default =>
}
