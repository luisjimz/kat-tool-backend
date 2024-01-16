package com.luisjimz.kattool.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountingReportModel {

    private Long id;
    private ClientModel client;
    private UserModel assignedUser;
    private Collection<AccountingOperationModel> operations;
    private Date creationDate;

}
