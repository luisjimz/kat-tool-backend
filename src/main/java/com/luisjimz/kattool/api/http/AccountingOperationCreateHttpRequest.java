package com.luisjimz.kattool.api.http;

import lombok.Data;

@Data
public class AccountingOperationCreateHttpRequest {
    private Long reportTypeId;
    private Long clientId;
    private Long userId;
}
