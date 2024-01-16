package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountingOperationStatusModel {
    private Long id;
    private Integer code;
    private String statusName;
    private String description;
    private String hexColor;
}
