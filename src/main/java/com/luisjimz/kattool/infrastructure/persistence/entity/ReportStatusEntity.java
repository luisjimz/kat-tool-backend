package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "report_status")
public class ReportStatusEntity {
    @Id
    @Column(name = "statusId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer code;
    private String statusName;
    private String description;
    private String hexColor;
    public ReportStatusEntity(Long id) {
        this.id = id;
    }
}
