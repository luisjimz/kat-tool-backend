package com.luisjimz.kattool.api.http;

import lombok.Data;

@Data
public class ReportCreateHttpRequest {
    private Long reportTypeId;
    private String clientId;
    private String assignedAccountant;
}
