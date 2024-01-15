package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
@Entity
@Data
@AllArgsConstructor
public class ReportTypeReportStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reportTypeId", nullable = false)
    private ReportTypeEntity reportType;

    @ManyToOne
    @JoinColumn(name = "statusId", nullable = false)
    private ReportStatusEntity status;

}
