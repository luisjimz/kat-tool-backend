package com.luisjimz.kattool.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "report_type")
public class ReportTypeEntity {

    @Id
    @Column(name = "typeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private final Date creationDate = new Date();

    @ManyToMany
    @JoinTable(
            name = "report_type_status", // name of the join table
            joinColumns = @JoinColumn(name = "typeId"),
            inverseJoinColumns = @JoinColumn(name = "statusId")
    )
    private Set<ReportStatusEntity> statuses;

    public ReportTypeEntity(Long id) {
        this.id = id;
    }
}
