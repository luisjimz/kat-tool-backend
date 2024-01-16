package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountingReportModel {

    private ClientModel client;
    private UserModel assignedUser;

}
