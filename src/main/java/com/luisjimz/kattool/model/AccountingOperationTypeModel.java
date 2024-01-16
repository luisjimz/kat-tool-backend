package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountingOperationTypeModel {
    private Long id;
    private String name;
    private String description;
    private Date creationDate;
    private Set<AccountingOperationStatusModel> statuses;
}
