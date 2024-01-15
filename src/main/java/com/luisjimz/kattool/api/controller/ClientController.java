package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.api.http.ClientCreateHttpRequest;
import com.luisjimz.kattool.api.mapper.ClientMapper;
import com.luisjimz.kattool.api.service.ReportService;
import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.api.service.ClientService;
import com.luisjimz.kattool.model.ReportModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Clients API")
public class ClientController {
    
    private ClientService clientService;
    private ReportService reportService;
    private ClientMapper mapper;

    @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
    })
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
