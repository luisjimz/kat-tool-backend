package com.luisjimz.kattool.api.controller;

import com.luisjimz.kattool.api.http.UserCreateHttpRequest;
import com.luisjimz.kattool.api.service.ClientService;
import com.luisjimz.kattool.api.service.ReportService;
import com.luisjimz.kattool.model.ReportModel;
import com.luisjimz.kattool.model.UserModel;
import com.luisjimz.kattool.api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@CrossOrigin
@Tag(name = "Users API")
public class UserController {

    private UserService userService;
    private ReportService reportService;
    private ClientService clientService;

    @GetMapping("users")
    public ResponseEntity<Collection<UserModel>> getUsers() {
        return ResponseEntity.ok(userService.get());
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<UserModel> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(
                userService.get(userId)
        );
    }

    @PostMapping("users")
    public ResponseEntity<UserModel> create(@RequestBody UserCreateHttpRequest user) {
        return ResponseEntity.ok(
                this.userService.save(
                        new UserModel(
                                null,
                                user.getName(),
                                user.getLastName(),
                                user.getEmail()
                        )
                )
        );
    }

    @DeleteMapping("users")
    public ResponseEntity<?> delete(Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("users/{userId}/reports")
    public ResponseEntity<Collection<ReportModel>> getReportsForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(reportService.findByUser(userId));
    }

    @GetMapping("users/{userId}/reports/{dateSlug}")
    public ResponseEntity<Collection<ReportModel>> getReportsForUserByDateSlug(
            @PathVariable Long userId,
            @PathVariable String dateSlug) {
        return ResponseEntity.ok(reportService.findByUserAndDateSlug(userId, dateSlug));
    }

//    @GetMapping("users/{userId}/clients")
//    public ResponseEntity<Collection<ReportModel>> getClientsByUserId(){
//        clientService.
//    }
}
