package com.luisjimz.kattool.api.http;

import lombok.Data;

@Data
public class AccountingOperationCreateHttpRequest {
    private Long accountingOperationTypeId;
    private Long clientId;
    private Long userId;
}
