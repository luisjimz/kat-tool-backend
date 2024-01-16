package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.domain.model.AccountingOperationTypeModel;
import com.luisjimz.kattool.domain.service.AccountingOperationTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Accounting Operation Types API")
public class AccountingOperationTypeController {

    private AccountingOperationTypeService service;
    @GetMapping("/accounting-operation-type")
    public List<AccountingOperationTypeModel> getAll() {
        return service.getAll();
    }

}
