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
}
