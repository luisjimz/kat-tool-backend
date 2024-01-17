package com.luisjimz.kattool.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
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
    private List<AccountingOperationStatusModel> statuses;

    public AccountingOperationTypeModel(Long id) {
        this.id = id;
    }
}
