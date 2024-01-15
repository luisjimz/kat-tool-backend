package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.model.ReportTypeModel;
import com.luisjimz.kattool.api.service.ReportTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Report Types API")
public class ReportTypeController {

    private ReportTypeService service;
    @GetMapping("/report-type")
    public List<ReportTypeModel> getAll() {
        return service.getAll();
    }

}
