package com.luisjimz.kattool.api.http;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientCreateHttpRequest {
    private String name;
    private String email;
    private String adminFullName;
    private String adminPhone;
    private String adminEmail;
    private String headquarterState;
    private List<Long> operations;
}
