package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "accounting_operation")
@NamedQuery(name = "AccountingOperationEntity.findByYearAndMonth",
        query = "SELECT m FROM AccountingOperationEntity m WHERE EXTRACT(YEAR FROM m.creationDate) = :year AND EXTRACT(MONTH FROM m.creationDate) = :month")
public class AccountingOperationEntity {
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
    private AccountingOperationTypeEntity accountingOperationType;

    @ManyToOne
    private AccountingOperationStatusEntity latestStatus;

    @Column(nullable = false)
    private final Date creationDate = new Date();}

