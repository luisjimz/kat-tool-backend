package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.api.http.ClientCreateHttpRequest;
import com.luisjimz.kattool.api.mapper.ClientMapper;
import com.luisjimz.kattool.api.service.ReportService;
import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.api.service.ClientService;
import com.luisjimz.kattool.model.ReportModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ClientController {
    
    private ClientService clientService;
    private ReportService reportService;
    private ClientMapper mapper;

    @GetMapping("clients")
    public ResponseEntity<Collection<ClientModel>> getClients() {
        return ResponseEntity.ok(clientService.get());
    }

    @GetMapping("clients/{clientId}")
    public ResponseEntity<ClientModel> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok(
                clientService.get(clientId)
        );
    }

    @PostMapping("clients")
    public ResponseEntity<ClientModel> create(@RequestBody ClientCreateHttpRequest client) {
        return ResponseEntity.ok(
                this.clientService.save(mapper.toModel(client))
        );
    }

    @DeleteMapping("clients")
    public ResponseEntity<?> delete(String id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("clients/{clientId}/reports")
    public ResponseEntity<Collection<ReportModel>> getReportsForClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(reportService.findByClient(clientId));
    }

}
