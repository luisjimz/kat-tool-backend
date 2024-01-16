package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Entity
@Table(name = "reports")
@NamedQuery(name = "ReportEntity.findByYearAndMonth",
        query = "SELECT m FROM ReportEntity m WHERE EXTRACT(YEAR FROM m.creationDate) = :year AND EXTRACT(MONTH FROM m.creationDate) = :month")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="report_type_id", nullable=false)
    private ReportTypeEntity reportType;

    @ManyToOne
    private ReportStatusEntity latestReportStatus;

    @Column(nullable = false)
    private final Date creationDate = new Date();}

