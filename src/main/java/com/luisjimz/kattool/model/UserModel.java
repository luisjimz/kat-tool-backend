package com.luisjimz.kattool.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserModel {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}
