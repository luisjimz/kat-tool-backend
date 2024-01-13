package com.luisjimz.kattool.controller;

import com.luisjimz.kattool.model.ReportTypeModel;
import com.luisjimz.kattool.service.ReportTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReportTypeController {

    private ReportTypeService service;
    @GetMapping("/report-type")
    public List<ReportTypeModel> getAll() {
        return service.getAll();
    }

}
