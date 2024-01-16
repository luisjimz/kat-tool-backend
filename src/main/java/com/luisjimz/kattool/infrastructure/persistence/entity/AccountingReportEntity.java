package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounting_report")
public class AccountingReportEntity {

    @Id
    @Column(name = "accountingReportId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private final Date creationDate = new Date();

    @OneToMany(mappedBy = "accountingReport")
    private Set<AccountingOperationEntity> operations;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity assignedUser;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

}