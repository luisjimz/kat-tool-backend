package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    private String id;
    private String name;
    private String email;
    private String adminFullName;
    private String adminPhone;
    private String adminEmail;
    private String headquarterState;
    private List<String> reports;

    public ClientModel(Object id, String name, String email) {
    }
}
