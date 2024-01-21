package com.luisjimz.kattool.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AccountingReportModel {

    private Long id;
    private ClientModel client;
    private UserModel assignedUser;
    private List<AccountingOperationModel> relatedOperations;
    private Date creationDate;

    public AccountingReportModel(ClientModel clientModel, UserModel userModel) {
        this.client = clientModel;
        this.assignedUser = userModel;
    }
}
