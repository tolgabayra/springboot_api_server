package com.bayraktolga.springapiserver.controller;

import com.bayraktolga.springapiserver.model.Product;
import com.bayraktolga.springapiserver.model.User;
import com.bayraktolga.springapiserver.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id, HttpServletRequest httpServletRequest){
        System.out.println(httpServletRequest);
        userService.delete(id);
        return ResponseEntity.ok("User has been deleted.");
    }

    @PutMapping("{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable Long id, @RequestBody User body){
        return ResponseEntity.ok(userService.update(id, body));
    }


}
