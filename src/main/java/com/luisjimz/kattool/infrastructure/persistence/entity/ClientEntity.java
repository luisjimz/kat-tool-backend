package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rfc;
    private String email;
    private String adminFullName;
    private String adminPhone;
    private String fiscalAddress;
    private String headquarterState;

    @ManyToMany
    @JoinTable(
            name = "clients_operations",
            joinColumns = @JoinColumn(name = "clientId"),
            inverseJoinColumns = @JoinColumn(name = "operationId")
    )
    private List<AccountingOperationTypeEntity> operationTypes;

    @ManyToOne
    private UserEntity assignedAccountant;

}
