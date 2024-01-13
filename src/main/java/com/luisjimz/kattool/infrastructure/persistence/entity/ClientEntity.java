package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String adminFullName;
    private String adminPhone;
    private String adminEmail;
    private String headquarterState;
    //todo add ReportEntity here relationship one to many
//    private List<String> reports;
}
