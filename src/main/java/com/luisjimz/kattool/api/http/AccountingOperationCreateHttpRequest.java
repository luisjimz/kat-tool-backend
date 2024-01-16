package com.luisjimz.kattool.api.http;

import lombok.Data;

@Data
public class AccountingOperationCreateHttpRequest {
    private Long accountingReportId;
    private Long accountingOperationTypeId;
}
