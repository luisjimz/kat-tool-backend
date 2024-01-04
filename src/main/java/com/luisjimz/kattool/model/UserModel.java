package com.luisjimz.kattool.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserModel {
    private String id;
    private String name;
    private String lastName;
    private String email;
}
