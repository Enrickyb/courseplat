package com.finance.finance_control_api.controllers.UserControllers;

import com.finance.finance_control_api.Services.TokenService;
import com.finance.finance_control_api.domain.user.AuthenticationDTO;
import com.finance.finance_control_api.domain.user.User;
import com.finance.finance_control_api.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {

        try {
            System.out.println(data.email());
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(),  data.password());

            var auth  = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());


            return ResponseEntity.ok().body(token);
        } catch (AuthenticationException e) {

            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());

        }

    }


    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid User user) {

        if(userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        User newUser = new User(user.getName(), user.getEmail(), encryptedPassword, user.getRole());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();

    }
}

