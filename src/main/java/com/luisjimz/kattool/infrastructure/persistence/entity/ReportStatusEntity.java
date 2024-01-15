package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class ReportStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer code;
    private String statusName;
    private String description;
    private String hexColor;

    @OneToMany(mappedBy = "status")
    private Set<ReportTypeReportStatusEntity> reportTypeReportStatusEntities;

    public ReportStatusEntity(Long id) {
        this.id = id;
    }
}
