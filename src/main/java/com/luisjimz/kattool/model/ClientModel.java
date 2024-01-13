package com.luisjimz.kattool.model;

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
    private String email;
    private String adminFullName;
    private String adminPhone;
    private String adminEmail;
    private String headquarterState;
    private List<String> reports;
}
