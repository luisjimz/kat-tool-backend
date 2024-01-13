package com.luisjimz.kattool.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReportTypeModel {
    private Long id;
    private String name;
    private String description;
    private Date creationDate;
}
