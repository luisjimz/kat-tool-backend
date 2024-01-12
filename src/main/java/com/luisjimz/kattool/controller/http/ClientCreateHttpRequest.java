package com.luisjimz.kattool.controller.http;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientCreateHttpRequest {
    public String name;
    public String email;
}
