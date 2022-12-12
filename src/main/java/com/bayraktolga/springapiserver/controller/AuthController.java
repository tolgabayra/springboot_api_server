package com.bayraktolga.springapiserver.controller;

import io.jsonwebtoken.Jwts;
import java.security.Key;
import com.bayraktolga.springapiserver.model.User;
import com.bayraktolga.springapiserver.repository.UserRepository;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;




    public AuthController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @PostMapping("/register")
    public ResponseEntity<User> register (@RequestBody User body){
        User newUser = new User();
        newUser.setUsername(body.getUsername());
        newUser.setEmail(body.getEmail());
        newUser.setPassword(
                passwordEncoder.encode(body.getPassword())
        );
        return new ResponseEntity(this.userRepository.save(newUser), HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity login (@RequestBody User body,HttpServletResponse response){
        User user = new User();
        user = this.userRepository.findByEmail(body.getEmail());
        if (user != null){
            if (passwordEncoder.matches(body.getPassword(), user.getPassword())) {
                try {
                    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

                    String access_token = Jwts.builder()
                            .setIssuer(user.getId().toString())
                            .setExpiration(new Date(System.currentTimeMillis() +60 *24*1000))
                            .signWith(key).compact();

                    System.out.println(access_token);
                    Cookie cookie = new Cookie("access_token", access_token);
                    cookie.setHttpOnly(true);
                    response.addCookie(cookie);
                    return ResponseEntity.ok("Login is successfully.");
                }catch (Exception e){
                    System.out.println(e);
                    return ResponseEntity.badRequest().body("bad request");
                }
            }else{
                return ResponseEntity.badRequest().body("Password does not exists.");

            }
        }else{
            return ResponseEntity.badRequest().body("Email does not exists.");

        }




    }
}
