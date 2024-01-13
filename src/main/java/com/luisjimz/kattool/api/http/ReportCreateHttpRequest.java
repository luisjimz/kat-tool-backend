package com.luisjimz.kattool.api.http;

import lombok.Data;

@Data
public class ReportCreateHttpRequest {
    private Long reportTypeId;
    private Long clientId;
    private Long userId;
}
