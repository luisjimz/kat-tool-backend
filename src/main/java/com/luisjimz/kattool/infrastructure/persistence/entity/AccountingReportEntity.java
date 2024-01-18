package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounting_report")
@NamedQuery(name = "AccountingReportEntity.findByYearAndMonth",
        query = "SELECT m FROM AccountingReportEntity m WHERE EXTRACT(YEAR FROM m.creationDate) = :year AND EXTRACT(MONTH FROM m.creationDate) = :month")
public class AccountingReportEntity {

    @Id
    @Column(name = "accountingReportId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity assignedUser;

    @OneToMany(mappedBy = "accountingReport")
    private List<AccountingOperationEntity> relatedOperations;

    @Column(nullable = false)
    private final Date creationDate = new Date();

}
