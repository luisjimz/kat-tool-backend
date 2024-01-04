package com.luisjimz.kattool.controller;

import com.luisjimz.kattool.controller.http.UserCreateHttpRequest;
import com.luisjimz.kattool.model.UserModel;
import com.luisjimz.kattool.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.get());
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        return ResponseEntity.ok(
                userService.get(userId)
        );
    }

    @PostMapping("users")
    public ResponseEntity<?> create(@RequestBody UserCreateHttpRequest user) {
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
    public ResponseEntity<?> delete(String id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

}
