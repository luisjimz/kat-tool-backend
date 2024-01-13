package com.luisjimz.kattool.model;

import lombok.Data;

import java.util.Date;

@Data
public class ReportTypeModel {
    private Integer id;
    private String name;
    private String description;
    private Date creationDate;
}
