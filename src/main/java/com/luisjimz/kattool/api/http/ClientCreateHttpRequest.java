package com.luisjimz.kattool.api.http;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientCreateHttpRequest {
    private String name;
    private String rfc;
    private String email;
    private String adminFullName;
    private String adminPhone;
    private String fiscalAddress;
    private String headquarterState;
    private List<Long> operations;
}
