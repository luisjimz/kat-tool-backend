package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.api.http.ReportCreateHttpRequest;
import com.luisjimz.kattool.api.mapper.ReportMapper;
import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.api.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class ReportController {
    private ReportService service;
    private ReportMapper mapper;
    @GetMapping("reports")
    public ResponseEntity<Collection<ReportModel>> getReports() {
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("reports/{reportId}")
    public ResponseEntity<ReportModel> getReport(@PathVariable String reportId) {
        return ResponseEntity.ok(
                service.get(reportId)
        );
    }

    @PostMapping("reports")
    public ResponseEntity<ReportModel> create(@RequestBody ReportCreateHttpRequest report) {
        return ResponseEntity.ok(
                this.service.save(mapper.toModel(report))
        );
    }

    @DeleteMapping("reports")
    public ResponseEntity<?> delete(String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}