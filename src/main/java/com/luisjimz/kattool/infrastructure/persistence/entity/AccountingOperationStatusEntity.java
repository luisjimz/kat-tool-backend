package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounting_operation_status")
public class AccountingOperationStatusEntity {
    @Id
    @Column(name = "statusId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer code;
    private String statusName;
    private String description;
    private String hexColor;
    public AccountingOperationStatusEntity(Long id) {
        this.id = id;
    }
}
