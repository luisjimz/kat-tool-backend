package com.luisjimz.kattool.api.http;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateHttpRequest {
    public String name;
    public String lastName;
    public String email;
}
