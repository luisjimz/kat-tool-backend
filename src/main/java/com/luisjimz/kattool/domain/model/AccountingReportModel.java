package com.luisjimz.kattool.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountingReportModel {

    private Long id;
    private ClientModel client;
    private UserModel assignedUser;
    private List<AccountingOperationModel> relatedOperations;
    private Date creationDate;

}
