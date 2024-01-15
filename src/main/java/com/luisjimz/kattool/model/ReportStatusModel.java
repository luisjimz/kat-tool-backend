package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportStatusModel {
    private Long id;
    private Integer code;
    private String statusName;
    private String description;
    private String hexColor;
}
