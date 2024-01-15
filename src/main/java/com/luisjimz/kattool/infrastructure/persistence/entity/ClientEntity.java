package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String email;
    private String adminFullName;
    private String adminPhone;
    private String adminEmail;
    private String headquarterState;
    //todo add ReportEntity here relationship one to many
//    private List<String> reports;
}
