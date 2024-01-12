package com.luisjimz.kattool.controller;

import com.luisjimz.kattool.controller.http.ClientCreateHttpRequest;
import com.luisjimz.kattool.model.ClientModel;
import com.luisjimz.kattool.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ClientController {
    
    private ClientService clientService;

    @GetMapping("clients")
    public ResponseEntity<?> getClients() {
        return ResponseEntity.ok(clientService.get());
    }

    @GetMapping("clients/{clientId}")
    public ResponseEntity<?> getClient(@PathVariable String clientId) {
        return ResponseEntity.ok(
                clientService.get(clientId)
        );
    }

    @PostMapping("clients")
    public ResponseEntity<?> create(@RequestBody ClientCreateHttpRequest client) {
        return ResponseEntity.ok(
                this.clientService.save(
                        new ClientModel(
                                null,
                                client.getName(),
                                client.getEmail()
                        )
                )
        );
    }

    @DeleteMapping("clients")
    public ResponseEntity<?> delete(String id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

}
