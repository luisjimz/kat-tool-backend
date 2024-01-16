package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.api.http.AccountingReportCreateHttpRequest;
import com.luisjimz.kattool.api.mapper.AccountingReportMapper;
import com.luisjimz.kattool.domain.model.AccountingReportModel;
import com.luisjimz.kattool.domain.service.AccountingReportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Tag(name = "Accounting Report API")
public class AccountingReportController {

    private AccountingReportService service;
    private AccountingReportMapper mapper;

    @GetMapping("/accounting-report")
    ResponseEntity<Collection<AccountingReportModel>> getReports() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/accounting-report")
    ResponseEntity<AccountingReportModel> create(@RequestBody AccountingReportCreateHttpRequest httpRequest) {
        return ResponseEntity.ok(service.save(mapper.toModel(httpRequest)));
    }


}
