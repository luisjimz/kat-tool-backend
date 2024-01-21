package com.luisjimz.kattool.domain.model;

import com.luisjimz.kattool.infrastructure.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientModel{
    private Long id;
    private String name;
    private String rfc;
    private String email;
    private String adminFullName;
    private String adminPhone;
    private String fiscalAddress;
    private String headquarterState;
    private List<AccountingOperationTypeModel> enabledOperations;
    private UserModel assignedAccountant;

    public ClientModel(String name, String rfc, String email, String adminFullName, String adminPhone, String fiscalAddress, String headquarterState, List<AccountingOperationTypeModel> enabledOperations, UserModel assignedAccountant) {
        this.name = name;
        this.rfc = rfc;
        this.email = email;
        this.adminFullName = adminFullName;
        this.adminPhone = adminPhone;
        this.fiscalAddress = fiscalAddress;
        this.headquarterState = headquarterState;
        this.enabledOperations = enabledOperations;
        this.assignedAccountant = assignedAccountant;
    }

    public ClientModel(Long id) {
        this.id = id;
    }
}
