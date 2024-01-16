package com.luisjimz.kattool.api.http;

import lombok.Data;

@Data
public class AccountingReportCreateHttpRequest {
    private Long clientId;
    private Long userId;
}
