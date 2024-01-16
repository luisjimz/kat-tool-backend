package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.api.http.ClientCreateHttpRequest;
import com.luisjimz.kattool.api.mapper.ClientMapper;
import com.luisjimz.kattool.domain.service.AccountingOperationService;
import com.luisjimz.kattool.domain.model.ClientModel;
import com.luisjimz.kattool.domain.service.ClientService;
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
    private AccountingOperationService accountingOperationService;
    private ClientMapper mapper;

    @Operation(summary = "Return all available clients", description = "Returns all available clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
    })
    @GetMapping("clients")
    public ResponseEntity<Collection<ClientModel>> getClients() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("clients/{clientId}")
    public ResponseEntity<ClientModel> getClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(
                clientService.getAll(clientId)
        );
    }

    @PostMapping("clients")
    public ResponseEntity<ClientModel> create(@RequestBody ClientCreateHttpRequest client) {
        return ResponseEntity.ok(
                this.clientService.save(mapper.toModel(client))
        );
    }

    @DeleteMapping("clients")
    public ResponseEntity<?> delete(Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

}
