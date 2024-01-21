package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.api.http.AccountingOperationCreateHttpRequest;
import com.luisjimz.kattool.api.http.AccountingOperationUpdateLatestStatusHttpRequest;
import com.luisjimz.kattool.api.mapper.AccountingOperationMapper;
import com.luisjimz.kattool.domain.model.AccountingOperationModel;
import com.luisjimz.kattool.domain.service.AccountingOperationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Tag(name = "Accounting Operation API")
public class AccountingOperationController {
    private AccountingOperationService service;
    private AccountingOperationMapper mapper;

    @GetMapping("accounting-operation")
    public ResponseEntity<Collection<AccountingOperationModel>> getAccountingOperations(
            @RequestParam(required = false, defaultValue = "01-2024") String dateSlug) {
        if (dateSlug != null) {
            return ResponseEntity.ok(
                    service.findByDateSlug(dateSlug)
            );
        }
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("accounting-operation/{accountingOperationId}")
    public ResponseEntity<AccountingOperationModel> getAccountingOperation(@PathVariable Long accountingOperationId) {
        return ResponseEntity.ok(
                service.getAll(accountingOperationId)
        );
    }

    @PatchMapping("accounting-operation/{accountingOperationId}")
    public ResponseEntity<AccountingOperationModel> patch(@PathVariable Long accountingOperationId,
                                                          @RequestBody AccountingOperationUpdateLatestStatusHttpRequest statudId) {
        return ResponseEntity.ok(
                service.updateLatestStatus(accountingOperationId, statudId.getStatusId())
        );
    }

    @PostMapping("accounting-operation")
    public ResponseEntity<AccountingOperationModel> create(@RequestBody AccountingOperationCreateHttpRequest report) {
        return ResponseEntity.ok(
                this.service.create(mapper.toModel(report))
        );
    }

    @DeleteMapping("accounting-operation")
    public ResponseEntity<?> delete(Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
