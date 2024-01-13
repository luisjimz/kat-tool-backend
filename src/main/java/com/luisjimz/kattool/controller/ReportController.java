package com.luisjimz.kattool.controller;

import com.luisjimz.kattool.controller.http.ReportCreateHttpRequest;
import com.luisjimz.kattool.controller.mapper.ReportMapper;
import com.luisjimz.kattool.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ReportController {
    private ReportService service;
    private ReportMapper mapper;

    @GetMapping("reports")
    public ResponseEntity<?> getReports() {
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("reports/{reportId}")
    public ResponseEntity<?> getReport(@PathVariable String reportId) {
        return ResponseEntity.ok(
                service.get(reportId)
        );
    }

    @PostMapping("reports")
    public ResponseEntity<?> create(@RequestBody ReportCreateHttpRequest report) {
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
