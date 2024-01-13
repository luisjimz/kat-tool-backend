package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReportTypeModel {
    private Long id;
    private String name;
    private String description;
    private Date creationDate;
}
